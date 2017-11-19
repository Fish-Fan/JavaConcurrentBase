package com.clientandserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by yanfeng-mac on 2017/11/6.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",20006);
        client.setSoTimeout(1000);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(client.getOutputStream());

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        boolean flag = true;

        while (flag) {
            System.out.println("输入信息: ");
            String str = input.readLine();

            out.println(str);
            if("bye".equals(str)) {
                flag = false;
            } else {
                String echo = buf.readLine();
                System.out.println(echo);
            }
        }

        input.close();
        if(client != null) {
            client.close();
        }
    }
}
