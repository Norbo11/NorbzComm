package com.github.norbo11.norbzcomm.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.github.norbo11.norbzcomm.messenger.Messenger;
import com.github.norbo11.norbzcomm.util.CommProtocol;
import com.github.norbo11.norbzcomm.util.ListeningThread;
import com.github.norbo11.norbzcomm.util.MessengerManager;
import com.github.norbo11.norbzcomm.util.NumberHelper;
import com.github.norbo11.norbzcomm.util.UIHelper;
import com.github.norbo11.norbzcomm.util.User;

public class BtnConnectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try {
            Socket clientSocket = null;
            
            clientSocket = new Socket(Main.getTextFieldHost().getText(), NumberHelper.toInt(Main.getTextFieldPort().getText()));
            UIHelper.showMessageDialog(Main.getFrame(), "Connected with " + clientSocket.getInetAddress() + "!");
            
            CommProtocol.setOutObjects(new ObjectOutputStream(clientSocket.getOutputStream()));
            CommProtocol.getOutObjects().flush();
            CommProtocol.setInObjects(new ObjectInputStream(clientSocket.getInputStream()));
            
            MessengerManager.setUser(new User(Main.getTextFieldUsername().getText()));
            MessengerManager.setSocket(clientSocket);
            
            Main.setMessenger(new Messenger());
            Main.getFrame().setVisible(false);
            
            MessengerManager.setThread(new ListeningThread());
            MessengerManager.getThread().start();
            
            
        } catch (NumberFormatException ex) {
        	UIHelper.showErrorDialog(Main.getFrame(), "Invalid port number!");
        } catch (UnknownHostException ex) {
        	UIHelper.showErrorDialog(Main.getFrame(), "Unknown host!");
        } catch (ConnectException ex)
        {
        	UIHelper.showErrorDialog(Main.getFrame(), "Could not connect!");
        } catch (Exception ex) {
        	
        	UIHelper.showErrorDialog(Main.getFrame(), ex.getMessage());
            ex.printStackTrace();
        }
    }
}
