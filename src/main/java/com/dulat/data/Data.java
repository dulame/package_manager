package com.dulat.data;

import com.dulat.controllers.FileCopierController;
import com.dulat.controllers.FileCreatorController;
import com.dulat.controllers.FileDeleterController;
import com.dulat.controllers.FileRenamerController;
import com.dulat.models.FileCopierModel;
import com.dulat.models.FileCreatorModel;
import com.dulat.models.FileDeleterModel;
import com.dulat.models.FileRenamerModel;
import com.dulat.views.FileCopierView;
import com.dulat.views.FileCreatorView;
import com.dulat.views.FileDeleterView;
import com.dulat.views.FileRenamerView;

import java.util.HashMap;

public class Data {
    private FileCreatorModel fileCreatorModel;
    private FileCreatorView fileCreatorView;
    private FileCreatorController fileCreatorController;

    private FileDeleterModel fileDeleterModel;
    private FileDeleterView fileDeleterView;
    private FileDeleterController fileDeleterController;

    private FileRenamerModel fileRenamerModel;
    private FileRenamerView fileRenamerView;
    private FileRenamerController fileRenamerController;

    private FileCopierModel fileCopierModel;
    private FileCopierView fileCopierView;
    private FileCopierController fileCopierController;

    private void initializeModels() {
        fileCreatorModel = new FileCreatorModel();
        fileDeleterModel = new FileDeleterModel();
        fileRenamerModel = new FileRenamerModel();
        fileCopierModel = new FileCopierModel();
    }

    private void initializeViews() {
        fileCreatorView = new FileCreatorView();
        fileDeleterView = new FileDeleterView();
        fileRenamerView = new FileRenamerView();
        fileCopierView = new FileCopierView();
    }

    private void initializeControllers() {
        fileCreatorController = new FileCreatorController(fileCreatorModel, fileCreatorView);
        fileDeleterController = new FileDeleterController(fileDeleterModel, fileDeleterView);
        fileRenamerController = new FileRenamerController(fileRenamerModel, fileRenamerView);
        fileCopierController = new FileCopierController(fileCopierModel, fileCopierView);
    }

    public Data() {
        initializeModels();
        initializeViews();
        initializeControllers();
    }

    public void setFileCreatorModelArgs(String fileName, String path) {
        fileCreatorModel.setFileName(fileName);
        fileCreatorModel.setPath(path);
    }

    public void setFileDeleterModelArgs(String fileName, String path) {
        fileDeleterModel.setFileName(fileName);
        fileDeleterModel.setPath(path);
    }

    public void setFileRenamerModelArgs(String fileName, String path, String renamingFileName) {
        fileRenamerModel.setFileName(fileName);
        fileRenamerModel.setPath(path);
        fileRenamerModel.setRenamingFileName(renamingFileName);
    }

    public void setFileCopierModel(String fileName, String initPath, String movingPath) {
        fileCopierModel.setFileName(fileName);
        fileCopierModel.setInitPath(initPath);
        fileCopierModel.setMovingPath(movingPath);
    }

    public FileCreatorController getFileCreatorController() {
        return fileCreatorController;
    }

    public FileDeleterController getFileDeleterController() {
        return fileDeleterController;
    }

    public FileRenamerController getFileRenamerController() {
        return fileRenamerController;
    }

    public FileCopierController getFileCopierController() {
        return fileCopierController;
    }
}
