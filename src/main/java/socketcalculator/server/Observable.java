package socketcalculator.server;

import java.util.HashMap;
import java.net.*;
import java.io.*;

public abstract class Observable{
    private HashMap<Socket, Integer> observers;

    public Observable(){
        this.observers = new HashMap<Socket, Integer>();
    }
    public void register(Socket client){
        this.observers.put(client, 10);
    }
    public void unregister(Socket client){
        this.observers.remove(client);
        System.out.println("unregistered");
    }
}