package com.dulat.controllers;

import com.dulat.models.FileDeleterModel;
import com.dulat.views.FileDeleterView;

public class FileDeleterController implements FileActionController {
    private final FileDeleterModel fileDeleterModel;
    private final FileDeleterView fileDeleterView;

    public FileDeleterController(FileDeleterModel fileDeleterModel, FileDeleterView fileDeleterView) {
        this.fileDeleterModel = fileDeleterModel;
        this.fileDeleterView = fileDeleterView;
    }

    @Override
    public void execute() {
        boolean res = fileDeleterModel.perform();

        if (res) {
            fileDeleterView.printSuccessfulAction(fileDeleterModel.getFileName());
        } else {
            fileDeleterView.printError(fileDeleterModel.getFileName());
        }
    }
}
