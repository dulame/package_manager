package com.dulat.data;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.dulat.settings.Configuration;

public final class FileCounter {
    // counter contains last count of file name if it exists
    private final HashMap<String, Integer> counter;

    public FileCounter(HashMap<String, Integer> counter) {
        this.counter = counter;
    }

    private String addAvailableNum(String fileName, int n) {
        if (n == 0) return fileName;

        int dotPosition = fileName.indexOf('.');
        return fileName.substring(0, dotPosition) + n + fileName.substring(dotPosition);
    }

    public String count(String fileName, String path) {
        if (counter.containsKey(fileName)) {
            counter.put(fileName, counter.get(fileName) + 1);
            return addAvailableNum(fileName, counter.get(fileName));
        }

        for (int i = 0; i <= Configuration.LIMIT_OF_SAME_FILE_NAMES; ++i) {
            String tempFileName = addAvailableNum(fileName, i);

            if (!Files.exists(Paths.get(path + File.separator + tempFileName))) {
                counter.put(fileName, i);
                return tempFileName;
            }
        }

        return "";
    }
}
