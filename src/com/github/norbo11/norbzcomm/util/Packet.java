package com.github.norbo11.norbzcomm.util;

import java.io.Serializable;

public class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	private String command;
	private Object payload;
	
	public Packet(String command, Object payload) {
		this.command = command;
		this.payload = payload;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
