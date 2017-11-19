package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by yanfeng-mac on 2017/10/9.
 */
public class LambdaTest {

    public static void main(String[] args) {
        String[] arr = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(arr));
        System.out.println("sort by dictionary");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("sort by length");

        Arrays.sort(arr,(s1, s2) -> s1.length() - s2.length());

        System.out.println(Arrays.toString(arr));

        Timer t = new Timer(3000,(event) -> {
            System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();



        JOptionPane.showMessageDialog(null,"Quit?");
        System.exit(0);
    }
}
