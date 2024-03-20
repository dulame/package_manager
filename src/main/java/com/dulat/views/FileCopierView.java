package com.dulat.views;

import com.dulat.Prettier;
import com.dulat.TextPrinter;

public class FileCopierView implements FileActionView {
    @Override
    public void printError(String fileName) {
        Prettier.printBackground(String.format("Not found path or file %s\n", fileName));
        TextPrinter.helpCopy();
        System.out.println();
    }

    @Override
    public void printSuccessfulAction(String fileName) {
        Prettier.printRegular(String.format("File %s was copied successfully\n", fileName));
    }
}
