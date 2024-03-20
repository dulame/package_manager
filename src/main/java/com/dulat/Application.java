package com.dulat;

import com.dulat.data.Data;
import com.dulat.inputs.ErrorState;
import com.dulat.inputs.Validator;
import com.dulat.settings.DefaultRoot;

import java.util.Scanner;

public class Application {
    boolean isRunning;
    private String defaultRoot;
    private static int offeredHelpCount = 0;
    private final static int offeredHelpCountLimit = 4;

    private Data data;

    public Application() {
        isRunning = true;
    }

    public void run() {
        TextPrinter.greetUser();

        Scanner sc = new Scanner(System.in);
        defaultRoot = DefaultRoot.getDefaultRoot();

        data = new Data();

        while (isRunning) {
            // Offer help just for several times
            if (offeredHelpCount <= offeredHelpCountLimit) {
                offeredHelpCount++;
                TextPrinter.offerHelp();
            }

            String argument = sc.nextLine();
            if (validate(argument)) {
                todo(argument);
            }
        }
    }

    private boolean validate(String argument) {
        ErrorState errorState = Validator.validate(argument);

        switch (errorState) {
            case NO_ERROR -> {
                return true;
            } case EMPTY_COMMAND_ERROR -> {
                Prettier.printBackground("Empty command!\n");
                return false;
            } case FEW_ARGUMENTS_ERROR -> {
                Prettier.printBackground("Few arguments!\n");
                return false;
            } case TOO_MANY_ARGUMENTS_ERROR -> {
                Prettier.printBackground("Too many arguments!\n");
                return false;
            } case INCORRECT_COMMAND_NAME -> {
                Prettier.printBackground("Incorrect command name!\n");
                return false;
            } case INCORRECT_FILE_NAME -> {
                Prettier.printBackground("Incorrect file name!\n");
                return false;
            }
        }

        return false;
    }

    private void todo(String argument) {
        String[] args = argument.split(" ");

        switch (args[0]) {
            case "create" -> {
                if (args[2].equals("-dr")) args[2] = defaultRoot;

                createFile(args[1], args[2]);
            } case "delete" -> {
                if (args[2].equals("-dr")) args[2] = defaultRoot;

                deleteFile(args[1], args[2]);
            } case "rename" -> {
                if (args[2].equals("-dr")) args[2] = defaultRoot;

                renameFile(args[1], args[2], args[3]);
            } case "copy" -> {
                if (args[2].equals("-dr")) args[2] = defaultRoot;
                if (args[3].equals("-dr")) args[2] = defaultRoot;

                copyFile(args[1], args[2], args[3]);
            } case "help" -> TextPrinter.help();
            case "quit" -> isRunning = false;
        }
    }

    private void createFile(String fileName, String path) {
        data.setFileCreatorModelArgs(fileName, path);
        data.getFileCreatorController().execute();
    }

    private void deleteFile(String fileName, String path) {
        data.setFileDeleterModelArgs(fileName, path);
        data.getFileDeleterController().execute();
    }

    private void renameFile(String fileName, String path, String renamingFileName) {
        data.setFileRenamerModelArgs(fileName, path, renamingFileName);
        data.getFileRenamerController().execute();
    }

    private void copyFile(String fileName, String initPath, String movingPath) {
        data.setFileCopierModel(fileName, initPath, movingPath);
        data.getFileCopierController().execute();
    }
}
