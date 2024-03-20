package com.dulat.settings;

import com.dulat.Prettier;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DefaultRoot {
    public static String getDefaultRoot() {
        String dir = Paths.get("").toAbsolutePath().toString();
        dir += File.separator + "src" + File.separator + "main";
        dir += File.separator + "resources";

        if (!Files.exists(Paths.get(dir))) {
            File f = new File(dir);
            if (f.mkdirs()) {
                Prettier.printBold("Created new directory: resources");
            }
        }

        return dir;
    }
}
