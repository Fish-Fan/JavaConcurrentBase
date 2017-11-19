package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

/**
 * Created by yanfeng-mac on 2017/10/9.
 */
public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        javax.swing.Timer t = new javax.swing.Timer(10000,event -> {
            System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();
        JOptionPane.showMessageDialog(null,"Quit?");
        System.exit(0);

    }
}
