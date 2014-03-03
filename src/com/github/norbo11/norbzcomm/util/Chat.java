package com.github.norbo11.norbzcomm.util;

import java.io.Serializable;
import java.util.ArrayList;

public class Chat implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3788955197456763638L;
    public Chat() {
    }

    public Chat(String name) {
        this.name = name;
    }

    private String name;
    private String owner;

    private ArrayList<String> operators = new ArrayList<String>();
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    private ArrayList<User> users = new ArrayList<User>();

    public String getName() {
        return name;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return name;
    }
}