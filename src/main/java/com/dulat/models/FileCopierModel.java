package com.dulat.models;

import com.dulat.data.FileCounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileCopierModel implements FileActionModel {
    private String fileName;
    private String initPath;
    private String movingPath;
    private final FileCounter fileCounter;

    public FileCopierModel(String fileName, String initPath, String movingPath, FileCounter fileCounter) {
        this.fileName = fileName;
        this.initPath = initPath;
        this.movingPath = movingPath;
        this.fileCounter = fileCounter;
    }

    public FileCopierModel() {
        fileCounter = new FileCounter(new HashMap<>(), null);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getInitPath() {
        return initPath;
    }

    public void setInitPath(String initPath) {
        this.initPath = initPath;
    }

    public String getMovingPath() {
        return movingPath;
    }

    public void setMovingPath(String movingPath) {
        this.movingPath = movingPath;
        fileCounter.setPath(movingPath);
    }

    @Override
    public boolean perform() {
        Path file = Paths.get(initPath + File.separator + fileName);
        boolean res = true;

        if (!Files.exists(Paths.get(movingPath))) {
            File f = new File(movingPath);
            res = f.mkdirs();
        }

        try {
            fileName = fileCounter.count(fileName);
            Files.copy(file, Paths.get(movingPath + File.separator + fileName));
        } catch (IOException e) {
            return false;
        }

        return res;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
