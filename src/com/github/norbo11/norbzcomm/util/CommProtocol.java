package com.github.norbo11.norbzcomm.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CommProtocol {

    private static ObjectOutputStream outObjects;
    private static ObjectInputStream inObjects;

    public static ObjectOutputStream getOutObjects() {
        return outObjects;
    }

    public static ObjectInputStream getInObjects() {
        return inObjects;
    }

    public static void setOutObjects(ObjectOutputStream outObjects) {
        CommProtocol.outObjects = outObjects;
    }

    public static void setInObjects(ObjectInputStream inObjects) {
        CommProtocol.inObjects = inObjects;
    }
    
    public static void sendSerialized(String command)
    {
        sendSerialized(command, null);
    }
    
    public static void sendSerialized(String command, Object payload)
    {
        try {
            outObjects.writeObject(new Packet(command, payload));
            outObjects.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendMessage(Message message)
    {
    	sendSerialized("MESSAGE", message);
    }
    
    public static void requestChatList() {
        sendSerialized("REQUEST CHATLIST");
    }

    public static void requestChat(String chatName) {
        sendSerialized("JOIN " + chatName);
    }

    public static void connect() {
        sendSerialized("CONNECT", MessengerManager.getUser());
    }

    @SuppressWarnings("unchecked")
	public static void process(Packet packet) {
    	Object payload = packet.getPayload();
        String line = (String) packet.getCommand();
        String[] args = line.split(" ");

        switch (args[0]) {
            case "CHATLIST":
                MessengerManager.updateChats((ArrayList<String>) payload);
                break;
            case "CHAT":
                MessengerManager.newChat((Chat) payload);
                break;
            case "MESSAGE":
                MessengerManager.receiveMessage((Message) payload);
                break;
        }
        return;
    }

}
