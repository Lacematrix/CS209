package cn.edu.sustech.cs209.chatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, ServerUser> userList = new HashMap<>();

    static List<String> user = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server");
        ServerSocket serverSocket = new ServerSocket(8999);
        while (true){
            System.out.println("wait");
            Socket newUser = serverSocket.accept();
            System.out.println("OK");
            BufferedReader reader = new BufferedReader(new InputStreamReader(newUser.getInputStream()));
            String userName = reader.readLine();
            ServerUser serverUser = new ServerUser(newUser, userName);
            userList.put(userName, serverUser);
            user.add(userName);
            ServerUser.init(userList, user);
            ServerUser.setUserList();
            serverUser.start();
        }
    }
}
