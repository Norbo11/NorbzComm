package com.github.norbo11.norbzcomm.messenger;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.github.norbo11.norbzcomm.util.MessengerManager;

public class SendMessageAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = Messenger.getSendMessageField().getText();
        if (text.length() > 0) MessengerManager.sendMessage(text);
	}
}
