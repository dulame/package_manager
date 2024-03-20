package com.dulat.views;

import com.dulat.Prettier;
import com.dulat.TextPrinter;

public class FileCreatorView implements FileActionView {
    @Override
    public void printError(String fileName) {
        Prettier.printBackground(String.format("Error while creating file %s\n", fileName));
        TextPrinter.helpCreate();
        System.out.println();
    }

    @Override
    public void printSuccessfulAction(String fileName) {
        Prettier.printRegular(String.format("File %s was created successfully\n", fileName));
    }
}
