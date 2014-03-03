package com.github.norbo11.norbzcomm.messenger;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.github.norbo11.norbzcomm.util.MessengerManager;

public class ChatListListener implements ListSelectionListener {

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting())
        {
            MessengerManager.changeChat(Messenger.getChatList().getSelectedValue());
        }
    }

}
