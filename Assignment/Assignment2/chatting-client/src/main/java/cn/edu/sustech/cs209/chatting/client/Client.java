package cn.edu.sustech.cs209.chatting.client;

import cn.edu.sustech.cs209.chatting.common.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Receiver receiver;

    private Sender sender;

    ObjectOutputStream write;

    ObjectInputStream read;

    private Socket socket;

    String[] userList;

    private Controller controller;

    public Client(String username, Controller controller) throws IOException{
        this.socket = new Socket("localhost", 8999);
        this.controller = controller;
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(username);
        write = new ObjectOutputStream(socket.getOutputStream());
        read = new ObjectInputStream(socket.getInputStream());
        receiver = new Receiver(this);
        sender = new Sender(this);
        receiver.start();
    }

    public void sendMessage(Message message) throws IOException {
        sender.send(message);
    }

    public Controller getController() {
        return controller;
    }

    public void updateUserList(){//有问题
        ObservableList<String> strList = FXCollections.observableArrayList();
        strList.addAll(userList);
        controller.update(strList);
    }

    public void updateMessagePerson(Message msg){
        controller.updateMsg(msg);
    }

}
