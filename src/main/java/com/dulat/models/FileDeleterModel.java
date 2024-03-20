package com.dulat.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDeleterModel implements FileActionModel {
    private String fileName;
    private String path;

    public FileDeleterModel(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public FileDeleterModel() {
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
            Path file = Paths.get(path + File.separator + fileName);
            Files.delete(file);
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
