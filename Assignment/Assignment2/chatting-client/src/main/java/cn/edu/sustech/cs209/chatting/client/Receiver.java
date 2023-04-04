package cn.edu.sustech.cs209.chatting.client;

import cn.edu.sustech.cs209.chatting.common.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Receiver extends Thread{

    Client client;


    public Receiver(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            Message message = null;
            try {
                message = (Message) client.read.readObject();
                if (message.getModel() == 0){
                    String[] userList = message.getUserList();
                    List<String> user = Arrays.asList(userList);
                    List<String> userReal = new ArrayList<>(user);
                    userReal.remove(client.getController().username);
                    userList = userReal.toArray(new String[]{});
                    client.userList = userList;
                }else if (message.getModel() == 1){
                    // TODO:show message;
                    client.updateMessagePerson(message);
                }
                client.updateUserList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
        }
    }
}
