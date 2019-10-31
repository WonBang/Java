package chat.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static final int PORT = 0;

    public static void main(String[] args){

        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket();

            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            serverSocket.bind(new InetSocketAddress(hostAddress, PORT));

            while(true){
                Socket socket = serverSocket.accept();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
