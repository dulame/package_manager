package com.dulat;

public class TextPrinter {
    public static void greetUser() {
        Prettier.printBold("PACKAGE SYSTEM has run");
    }

    public static void offerHelp() {
        Prettier.printBold("You can always type help to get list of commands\n");
    }

    public static void help() {
        helpHandler();
        helpCreate();
        helpDelete();
        helpRename();
        helpCopy();
        helpQuit();
        helpHelp();
        System.out.println();
    }

    public static void helpHandler() {
        Prettier.printBold("\nThe commands are wrote in 1 line like in terminal. Example usages are wrote in []");
        Prettier.printBold("The -dr is default root.");
    }

    public static void helpCreate() {
        Prettier.printRegular(Prettier.getBold("create") + " - command to create file with optional given directory.");
        System.out.println("\t[create file_name directory]");
        System.out.println("\t[create file_name -dr]");
    }

    public static void helpDelete() {
        Prettier.printRegular(Prettier.getBold("delete") + " - command to delete file with optional given directory.");
        System.out.println("\t[delete file_name directory]");
        System.out.println("\t[delete file_name -dr]");
    }

    public static void helpRename() {
        Prettier.printRegular(Prettier.getBold("rename") + " - command to rename file with optional given directory and given file renamer name.");
        System.out.println("\t[rename file_name directory renamer_file_name]");
        System.out.println("\t[rename file_name -dr renamer_file_name]");
    }

    public static void helpCopy() {
        Prettier.printRegular(Prettier.getBold("copy") + " - command to copy file with optional given directory and given directory.");
        System.out.println("\t[copy file_name initial_dir moving_dir]");
        System.out.println("\t[copy file_name -dr moving_dir]");
        System.out.println("\t[copy file_name initial_dir -dr]");
    }

    public static void helpQuit() {
        Prettier.printRegular(Prettier.getBold("quit") + " - command to quit program.");
        System.out.println("\t[quit]");
    }

    public static void helpHelp() {
        Prettier.printRegular( Prettier.getBold("help") + " - command to get list of program facilities.");
        System.out.println("\t[help]");
    }
}
