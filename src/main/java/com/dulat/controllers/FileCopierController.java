package com.dulat.controllers;

import com.dulat.models.FileCopierModel;
import com.dulat.views.FileCopierView;

public class FileCopierController implements FileActionController {
    private final FileCopierModel fileCopierModel;
    private final FileCopierView fileCopierView;

    public FileCopierController(FileCopierModel fileCopierModel, FileCopierView fileCopierView) {
        this.fileCopierModel = fileCopierModel;
        this.fileCopierView = fileCopierView;
    }

    @Override
    public void execute() {
        boolean res = fileCopierModel.perform();

        if (res) {
            fileCopierView.printSuccessfulAction(fileCopierModel.getFileName());
        } else {
            fileCopierView.printError(fileCopierModel.getFileName());
        }
    }
}
