package com.dulat.models;

import com.dulat.data.FileCounter;
import com.dulat.settings.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileCreatorModel implements FileActionModel {
    private String fileName;
    private String path;

    private final FileCounter fileCounter;

    public FileCreatorModel(String fileName, String path, FileCounter fileCounter) {
        this.fileName = fileName;
        this.path = path;
        this.fileCounter = fileCounter;
    }

    public FileCreatorModel() {
        fileCounter = new FileCounter(new HashMap<>());
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean perform() {
        try {
            fileName = fileCounter.count(fileName, path);
            Path file = Paths.get(path + File.separator + fileName);
            Files.createFile(file);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
