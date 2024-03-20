package com.dulat;

public class Prettier {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String YELLOW_BACKGROUND = "\033[43m";

    public static void printRegular(String s) {
        System.out.println(ANSI_GREEN + s + ANSI_RESET);
    }

    public static String getRegular(String s) {
        return ANSI_GREEN + s + ANSI_RESET;
    }

    public static void printBold(String s) {
        System.out.println(GREEN_BOLD + s + ANSI_RESET);
    }

    public static String getBold(String s) {
        return GREEN_BOLD + s + ANSI_RESET;
    }

    public static void printBackground(String s) {
        System.out.println(YELLOW_BACKGROUND + ANSI_BLACK + s + ANSI_RESET);
    }

    public static String getBackground(String s) {
        return YELLOW_BACKGROUND + ANSI_BLACK + s + ANSI_RESET;
    }
}
