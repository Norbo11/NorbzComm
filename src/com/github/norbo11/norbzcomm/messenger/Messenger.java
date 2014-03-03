package com.github.norbo11.norbzcomm.messenger;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.MatteBorder;

import com.github.norbo11.norbzcomm.util.MessengerManager;
import com.github.norbo11.norbzcomm.util.User;

public class Messenger {

    private static JFrame frame;
    private static JList<String> chatList;
    private static JList<User> userList;
    private static DefaultListModel<User> userListModel;
    private static JButton btnSend;
    private static JTextPane receivedText;
    
    public static JButton getBtnSend() {
        return btnSend;
    }

    public static DefaultListModel<User> getUserListModel() {
        return userListModel;
    }

    private static JTextArea sendMessageField;
    private static MessengerManager messengerManager;
    
    public static JList<String> getChatList() {
        return chatList;
    }

    public static JList<User> getUserList() {
        return userList;
    }

    public static JTextPane getReceivedText() {
        return receivedText;
    }

    public static MessengerManager getMessengerManager() {
        return messengerManager;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public Messenger() 
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 711, 415);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
        
        messengerManager = new MessengerManager();
        
        frame.setVisible(true);
    }
    
    public static void initialize()
    {        
        chatList = new JList<String>(new DefaultListModel<String>());
        chatList.addListSelectionListener(new ChatListListener());
        chatList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        chatList.setBounds(10, 11, 132, 355);
        frame.getContentPane().add(chatList);
        
        userListModel = new DefaultListModel<User>();
        userList = new JList<User>(userListModel);
        userList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        userList.setBounds(574, 11, 111, 248);
        frame.getContentPane().add(userList);

        
        SendMessageAction action = new SendMessageAction();
        
        sendMessageField = new JTextArea();
        sendMessageField.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), action);
        sendMessageField.getInputMap().put(KeyStroke.getKeyStroke("shift ENTER"), new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessageField.append("\n");
			}
		});
        sendMessageField.setBounds(152, 269, 412, 97);
        frame.getContentPane().add(sendMessageField);
        
        btnSend = new JButton("Send");
        btnSend.addActionListener(action);
        btnSend.setBounds(574, 270, 111, 96);
        frame.getContentPane().add(btnSend);
        
        receivedText = new JTextPane();
        receivedText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receivedText);
        scrollPane.setBounds(152, 11, 412, 248);
        frame.getContentPane().add(scrollPane);
    }

	public static JTextArea getSendMessageField() {
		return sendMessageField;
	}
}
