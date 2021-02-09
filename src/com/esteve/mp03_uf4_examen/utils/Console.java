package com.esteve.mp03_uf4_examen.utils;

import java.util.Scanner;

public class Console {
    public static void log(String log) {
        System.out.println(log);
    }

    public static String string(String label) {
        Scanner sc = new Scanner(System.in);
        System.out.print(label);
        String in = sc.nextLine();
        return in;
    }

    public static int integer(String label) {
        Scanner sc = new Scanner(System.in);
        System.out.print(label);
        int res = 0;
        try {
            res = sc.nextInt();
        } catch(Exception e) {
            System.out.println("[Error] Value must be numeric!");
            res = integer(label);
        }
        return res;
    }

    public static int integer(String label, int min, int max) {
        Scanner sc = new Scanner(System.in);
        System.out.print(label);
        int res = 0;
        try {
            res = sc.nextInt();
        } catch(Exception e) {
            System.out.println("[Error] Value must be numeric!");
            res = integer(label);
        }
        if(res > max || res < min) {
            System.out.println("[Error] Value must be between " + min + " and " + max);
            res = integer(label, min, max);
        }
        return res;
    }

    public static double decimal(String label) {
        Scanner sc = new Scanner(System.in);
        System.out.print(label);
        double res = 0;
        try {
            res = sc.nextInt();
        } catch(Exception e) {
            System.out.println("[Error] Value must be decimal!");
            res = integer(label);
        }
        return res;
    }

    public static double decimal(String label, double min, double max) {
        Scanner sc = new Scanner(System.in);
        System.out.print(label);
        double res = 0;
        try {
            res = sc.nextDouble();
        } catch(Exception e) {
            System.out.println("[Error] Value must be decimal!");
            res = integer(label);
        }
        if(res > max || res < min) {
            System.out.println("[Error] Value must be between " + min + " and " + max);
            res = decimal(label, min, max);
        }
        return res;
    }

    public static void pause() {
        string("Press any key to continue...");
    }
}
