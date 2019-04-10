package socketcalculator.server;

import java.net.*;
import java.io.*;


public class Server extends Observable{

    private ServerSocket serverSocket;

    public Server(){
        super();
    }

    public void start(int port) {
        try{
            this.serverSocket = new ServerSocket(port);
        }catch(IOException e){

        }
        while(true){
            try{
                Socket clientSocket = this.serverSocket.accept();
                ClientThread client = new ClientThread(clientSocket, this);
                client.start();
            }catch(IOException e){

            }
            
        }
    }
 
    public void stop() {
        try{
            serverSocket.close();
        }catch(IOException e){

        }
    }

    public static void main(String[] args){
        Server server = new Server();
        server.start(8050);
        System.out.println("Server");
    }

}