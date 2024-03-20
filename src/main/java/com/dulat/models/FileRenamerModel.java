package com.dulat.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRenamerModel implements FileActionModel {
    private String fileName;
    private String path;
    private String renamingFileName;

    public FileRenamerModel(String fileName, String path, String renamingFileName) {
        this.fileName = fileName;
        this.path = path;
        this.renamingFileName = renamingFileName;
    }

    public FileRenamerModel() {
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRenamingFileName() {
        return renamingFileName;
    }

    public void setRenamingFileName(String renamingFileName) {
        this.renamingFileName = renamingFileName;
    }

    @Override
    public boolean perform() {
        try {
            Path file = Paths.get(path + File.separator + fileName);
            Files.move(file, file.resolveSibling(renamingFileName));
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
