package com.clientandserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yanfeng-mac on 2017/11/6.
 */
public class ServerThread implements Runnable{
    private Socket client = null;
    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));

            boolean flag = true;
            while (flag) {
                String str = buf.readLine();

                if(str == null || "".equals(str)) {
                    flag = false;
                } else {
                    if("bye".equals(str)) {
                        flag = false;
                    } else {
                        out.println("echo: " + str);
                    }
                }
            }
            out.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(20006);
        Socket client = null;
        boolean f = true;
        while (f) {
            client = server.accept();
            System.out.println("与客户端连接成功");

            new Thread(new ServerThread(client)).start();
        }

        server.close();
    }
}
