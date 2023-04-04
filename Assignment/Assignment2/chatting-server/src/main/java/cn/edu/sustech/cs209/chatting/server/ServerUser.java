package cn.edu.sustech.cs209.chatting.server;

import cn.edu.sustech.cs209.chatting.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Map;

public class ServerUser extends Thread{

    private static Map<String,ServerUser> userList;

    private static List<String> user;

    private String username;

    ObjectInputStream msgIn;
    ObjectOutputStream msgOut;


    public ServerUser(Socket socket, String username) throws IOException {
        msgIn = new ObjectInputStream(socket.getInputStream());
        msgOut = new ObjectOutputStream(socket.getOutputStream());
        this.username = username;
    }

    public static void init(Map<String, ServerUser> userList, List<String> user){
        ServerUser.userList = userList;
        ServerUser.user = user;
    }

    public static void setUserList() {
        String[] userSend = user.toArray(new String[]{});
        Message message = new Message(userSend);
        userList.forEach((s, serverUser) -> {
            try {
                serverUser.msgOut.writeObject(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void run() {
        try {
            while (true){
                Message message = (Message) msgIn.readObject();
                if (message.getModel() == 1) {
                    String sendTo = message.getSendTo();
                    ServerUser send = userList.get(sendTo);
                    send.msgOut.writeObject(message);
                }else if (message.getModel() == 3){

                }
             }
        }catch (SocketException e){
            ServerUser.userList.remove(username);
            ServerUser.user.remove(username);
            ServerUser.setUserList();
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
