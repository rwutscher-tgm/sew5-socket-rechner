package socketcalculator.client;

import java.net.*;
import java.io.*;


public class Client extends Observer{
    
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    public Client(){
        super();
    }

    public void connect(String ip, int port) {
        try{
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch(IOException e){

        }
    }

    public String send(String msg) {
        try{
            out.println(msg);
            String resp = in.readLine();
            if(msg.equals("!exit")){
                this.disconect();
            }
            return resp;
        }catch(IOException e){
            return null;
        }
    }

    public void disconect() {
        try{
            in.close();
            out.close();
            clientSocket.close();
        }catch(IOException e){

        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.connect("localhost", 8050);
        System.out.println(client.send("!no 1 3"));
        System.out.println(client.send("!add 1 1"));
        System.out.println(client.send("!exit"));
        client.disconect();
    }
}