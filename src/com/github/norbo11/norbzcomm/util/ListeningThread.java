package com.github.norbo11.norbzcomm.util;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;

import com.github.norbo11.norbzcomm.main.Main;
import com.github.norbo11.norbzcomm.messenger.Messenger;

public class ListeningThread extends Thread {

    @Override
    public void run()
    {
        while (true)
        {
            try {
                Object object = CommProtocol.getInObjects().readObject();
                if (object != null) CommProtocol.process((Packet) object);
            } catch (EOFException | SocketException e)
            {
            	UIHelper.showErrorDialog(Messenger.getFrame(), "Lost connection with server!");
            	Messenger.getFrame().setVisible(false);
            	Main.getFrame().setVisible(true);
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
