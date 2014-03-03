package com.github.norbo11.norbzcomm.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

public class UIHelper {
    public static void showErrorDialog(Component c, Object o) {
        JOptionPane.showMessageDialog(c, o, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void showMessageDialog(Component c, Object o) {
        JOptionPane.showMessageDialog(c, o);
    }

	public static void appendColoredString(JTextPane textPane, String text, Color color) {
		try {
			Document doc = textPane.getDocument();
			Style style = textPane.addStyle("", null);
			StyleConstants.setForeground(style, Color.blue);
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public static void scrollToBottom(JTextPane textPane) {
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	public static void appendString(JTextPane textPane, String text) {
		try {
			Document doc = textPane.getDocument();
			doc.insertString(doc.getLength(), text, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
