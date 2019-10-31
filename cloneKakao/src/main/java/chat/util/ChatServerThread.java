package chat.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread{

    private String userNickname = null;
    private Socket socket = null;
    List<PrintWriter> listWriters = null;

    public ChatServerThread(Socket socket, List<PrintWriter> listWriters){
        this.socket = socket;
        this.listWriters = listWriters;
    }

    @Override
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            while(true){
                String request = br.readLine();

                if(request == null){
                    consoleLog("접속 끊김");
                    break;
                }

                String[] tokens = request.split(":");
                if(tokens[0].equals("join")){
                    doJoin(tokens[1], pw);
                }else if(tokens[0].equals("message")){
                    doMessage(tokens[1]);
                }else if(tokens[0].equals("quit")){
                    doQuit(pw);
                }
            }

        }catch (Exception e){
            consoleLog(this.userNickname + "님이 나갔습니다.");
        }
    }

    private void consoleLog(String str) {
        System.out.println(str);
    }

    private void doJoin(String userNickname, PrintWriter pw){
        this.userNickname = userNickname;

        String str = userNickname + "님이 입장하였습니다.";
        broadcast(str);

        addWriter(pw);
    }

    private void doMessage(String str){
        broadcast(this.userNickname + ":" + str);
    }

    private void doQuit(PrintWriter pw){
        removeWriter(pw);

        String data = this.userNickname + "님이 퇴장했습니다.";
        broadcast(data);
    }

    private void broadcast(String data) {
        synchronized (listWriters) {
            for(PrintWriter writer : listWriters) {
                writer.println(data);
                writer.flush();
            }
        }
    }

    private void addWriter(PrintWriter pw) {
        synchronized (listWriters) {
            listWriters.add(pw);
        }
    }

    private void removeWriter(PrintWriter pw) {
        synchronized (listWriters) {
            listWriters.remove(pw);
        }
    }
}
