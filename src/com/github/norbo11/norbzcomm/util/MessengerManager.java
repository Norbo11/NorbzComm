package com.github.norbo11.norbzcomm.util;

import java.awt.Color;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JTextPane;

import com.github.norbo11.norbzcomm.messenger.Messenger;


public class MessengerManager {
    private static Chat currentChat;
    private static User user;
    private static Socket socket;
    private static ListeningThread thread;
    
    public static ListeningThread getThread() {
        return thread;
    }

    public static void setThread(ListeningThread thread) {
        MessengerManager.thread = thread;
    }

    public static Socket getSocket() {
        return socket;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MessengerManager.user = user;
    }

    public static Chat getCurrentChat() {
        return currentChat;
    }

    public static void setCurrentChat(Chat currentChat) {
        MessengerManager.currentChat = currentChat;
    }

    public MessengerManager()
    {
        CommProtocol.connect();
        CommProtocol.requestChatList();
    }

    public static void updateChats(ArrayList<String> chatNames)
    {    	
        DefaultListModel<String> listModel = (DefaultListModel<String>) Messenger.getChatList().getModel();
        listModel.clear();
        for (String chat : chatNames)
        {
            listModel.addElement(chat);
        }
    }

    public static void changeChat(String chatName) {
    	 CommProtocol.requestChat(chatName);
    }

    public static void setSocket(Socket socket) {
        MessengerManager.socket = socket;
    }

	public static void newChat(Chat payload) {
		currentChat = payload;
		updateEverything();
	}

	public static void receiveMessage(Message message) {
		JTextPane receivedText = Messenger.getReceivedText();
		
		if (message.getSender() == null) { //Server message
			UIHelper.appendColoredString(receivedText, message.getFormattedMessage() + "\n", Color.blue);
		} else UIHelper.appendString(receivedText, message.getFormattedMessage() + "\n");
		
		UIHelper.scrollToBottom(receivedText);
	}

	public static void sendMessage(String text) {
		CommProtocol.sendMessage(new Message(new Date().getTime(), user, text));
		Messenger.getSendMessageField().setText("");
	}
	
	public static void updateTitle()
    {
        Messenger.getFrame().setTitle(MessengerManager.getCurrentChat().getName());
    }
    
    public static void updateEverything() {
        
        updateTitle();
        updateReceivedText();
        updateUserList();
    }

    public static void updateUserList() {
    	DefaultListModel<User> userListModel = Messenger.getUserListModel();
        userListModel.clear();
        for (User user : MessengerManager.getCurrentChat().getUsers())
        {
            userListModel.addElement(user);
        }
    }

    public static void updateReceivedText() {
        Messenger.getReceivedText().setText("");
    }
}
