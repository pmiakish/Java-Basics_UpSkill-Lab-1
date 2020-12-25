package com.epam.textfile.service;

import com.epam.textfile.entity.TextFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TextFileWorker {

    public static boolean create(TextFile file) throws IOException {
        Path directory = file.getDirectory();
        Path pathToFile = directory.resolve(file.getFileName());
        if (Files.exists(pathToFile)) {
            return false;
        }
        if (Files.notExists(directory)) {
            Files.createDirectories(directory);
        }
        Files.createFile(pathToFile);
        return true;
    }

    public static boolean delete(TextFile file) throws IOException {
        Path pathToFile = file.getDirectory().resolve(file.getFileName());
        if (Files.exists(pathToFile)) {
            Files.delete(pathToFile);
            return true;
        }
        return false;
    }

    public static List<String> read(TextFile file) throws IOException {
        List<String> fileLines = null;
        Path pathToFile = file.getDirectory().resolve(file.getFileName());
        if (Files.exists(pathToFile) && Files.isReadable(pathToFile)) {
            fileLines = Files.readAllLines(pathToFile);
        }
        return fileLines;
    }

    public static boolean write(TextFile file, String str) throws IOException {
        Path pathToFile = file.getDirectory().resolve(file.getFileName());
        if (Files.exists(pathToFile) && Files.isWritable(pathToFile) && str != null) {
            Files.writeString(pathToFile, str, StandardOpenOption.APPEND);
            return true;
        }
        return false;
    }

}
