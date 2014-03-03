package com.github.norbo11.norbzcomm.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.norbo11.norbzcomm.messenger.Messenger;

public class Main {

    public static JFrame getFrame() {
        return frame;
    }

    private static JFrame frame;
    private static JTextField textFieldHost;
    private static JTextField textFieldPort;
    private static JTextField textFieldUsername;
    private static Messenger messenger;
    
    public static Messenger getMessenger() {
        return messenger;
    }

    public static void setMessenger(Messenger messenger) {
        Main.messenger = messenger;
    }

    public static JTextField getTextFieldHost() {
        return textFieldHost;
    }

    public static JTextField getTextFieldPort() {
        return textFieldPort;
    }

    public static JTextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public static void main(String[] args) 
    {        
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 379, 163);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        initialize();
        frame.setVisible(true);
    }

    private static void initialize() 
    {
        textFieldHost = new JTextField();
        textFieldHost.setText("localhost");
        textFieldHost.setBounds(101, 12, 266, 20);
        textFieldHost.setColumns(10);
        frame.getContentPane().add(textFieldHost);
        
        textFieldPort = new JTextField();
        textFieldPort.setText("211");
        textFieldPort.setBounds(101, 43, 266, 20);
        textFieldPort.setColumns(10);
        frame.getContentPane().add(textFieldPort);
        
        textFieldUsername = new JTextField();
        textFieldUsername.setText("Norbo11");
        textFieldUsername.setColumns(10);
        textFieldUsername.setBounds(101, 75, 266, 20);
        frame.getContentPane().add(textFieldUsername);
        
        JLabel lblIp = new JLabel("Host:");
        lblIp.setBounds(10, 15, 74, 14);
        frame.getContentPane().add(lblIp);
        
        JLabel lblMessage = new JLabel("Port:");
        lblMessage.setBounds(10, 46, 74, 14);
        frame.getContentPane().add(lblMessage);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 78, 74, 14);
        frame.getContentPane().add(lblUsername);
        
        JButton btnConnect = new JButton("Connect!");
        btnConnect.addActionListener(new BtnConnectListener());
        btnConnect.setBounds(10, 106, 357, 23);
        frame.getContentPane().add(btnConnect);
        
    }
}
