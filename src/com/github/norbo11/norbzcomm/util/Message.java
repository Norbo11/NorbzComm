package com.github.norbo11.norbzcomm.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private long timestamp;
    private User sender;
    private String text;
    
    //Sender = null if message belongs to server
    public Message(long timestamp, String text) {
        this(timestamp, null, text);
    }
    
    public Message(long timestamp, User user, String text) {
        this.sender = user;
        this.text = text;
        this.timestamp = timestamp;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public User getSender() {
        return sender;
    }
    
    public String getText() {
        return text;
    }
    
    public String getFormattedTimestamp()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }
    
    public String getFormattedMessage()
    {
        String msg = "[" + getFormattedTimestamp() + "]  ";
        msg += sender != null ? sender.getUsername() + ": " : "";
        msg += text;
        return msg;
    }
    
    public String toString()
    {
        return text;
    }
    
}
