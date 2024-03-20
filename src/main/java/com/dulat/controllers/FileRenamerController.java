package com.dulat.controllers;

import com.dulat.models.FileRenamerModel;
import com.dulat.views.FileRenamerView;

public class FileRenamerController implements FileActionController {
    private final FileRenamerModel fileRenamerModel;
    private final FileRenamerView fileRenamerView;

    public FileRenamerController(FileRenamerModel fileRenamerModel, FileRenamerView fileRenamerView) {
        this.fileRenamerModel = fileRenamerModel;
        this.fileRenamerView = fileRenamerView;
    }

    @Override
    public void execute() {
        boolean res = fileRenamerModel.perform();

        if (res) {
            fileRenamerView.printSuccessfulAction(fileRenamerModel.getFileName());
        } else {
            fileRenamerView.printError(fileRenamerModel.getFileName());
        }
    }
}
