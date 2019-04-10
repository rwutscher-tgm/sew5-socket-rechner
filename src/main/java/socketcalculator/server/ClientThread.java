package socketcalculator.server;

import java.lang.Thread;
import java.net.*;
import java.io.*;

public class ClientThread extends Thread{
    
    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
        try{
            this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        }catch(IOException e){
            
        }
    }

    public void run() {
        try{
            String calc = this.in.readLine();
            this.out.println(calc);
        }catch(IOException e){

        }
    }

    public void close() {
        try{
            in.close();
            out.close();
            clientSocket.close();
        }catch(IOException e){

        }
    }

}