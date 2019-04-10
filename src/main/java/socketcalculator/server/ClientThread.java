package socketcalculator.server;

import java.lang.Thread;
import java.net.*;
import java.io.*;

public class ClientThread extends Thread{
    
    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;
    private Server server;

    public ClientThread(Socket clientSocket, Server server){
        this.clientSocket = clientSocket;
        this.server = server;
        try{
            this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        }catch(IOException e){
            
        }
    }

    public void run() {
        while(true){
            try{
                String calc = this.in.readLine();
                this.out.println(calc);
                
                if(calc.equals("!exit")){
                    this.out.println("goodbye");
                    break;
                }
            }catch(IOException e){
                break;
            }
        }
        this.close();
    }

    public void close() {
        try{
            in.close();
            out.close();
            clientSocket.close();
            server.unregister(this.clientSocket);
        }catch(IOException e){

        }
    }

}