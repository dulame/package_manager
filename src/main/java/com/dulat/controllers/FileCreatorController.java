package com.dulat.controllers;

import com.dulat.models.FileCreatorModel;
import com.dulat.views.FileCreatorView;

public class FileCreatorController implements FileActionController {
    private final FileCreatorModel fileCreatorModel;
    private final FileCreatorView fileCreatorView;

    public FileCreatorController(FileCreatorModel fileCreatorModel, FileCreatorView fileCreatorView) {
        this.fileCreatorModel = fileCreatorModel;
        this.fileCreatorView = fileCreatorView;
    }

    @Override
    public void execute() {
        boolean res = fileCreatorModel.perform();

        if (res) {
            fileCreatorView.printSuccessfulAction(fileCreatorModel.getFileName());
        } else {
            fileCreatorView.printError(fileCreatorModel.getFileName());
        }
    }
}
