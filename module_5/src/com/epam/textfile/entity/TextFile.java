package com.epam.textfile.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Pattern;

public class TextFile {

    private static int counterId = 0;
    private static final String DIRECTORY_PATTERN = "^(?:[\\w-]+\\\\)+$";
    private static final String PREFIX_OF_NAME_PATTERN = "^[\\w-]+$";
    private static final String FILE_NAME_PATTERN = "^[\\w-]+\\.[A-Za-z0-9]+$";

    private Path directory;
    private Path fileName;

    public TextFile(String directory, String prefixOfName) throws IllegalArgumentException {
        if (isCorrectDirectory(directory) && isCorrectPrefixOfName(prefixOfName)) {
            this.directory = Paths.get(directory);
            this.fileName = Paths.get(prefixOfName + counterId++ + ".txt");
        } else {
            throw new IllegalArgumentException("Incorrect directory. Can't create the path!");
        }
    }

    public Path getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) throws IOException {
        Path pathToFile = this.directory.resolve(this.fileName);
        if (isCorrectDirectory(directory)) {
            Path newDirectory = Paths.get(directory);
            if (Files.exists(pathToFile)) {
                if (Files.notExists(newDirectory)) {
                    Files.createDirectories(newDirectory);
                }
                Files.move(pathToFile, newDirectory.resolve(this.fileName));
            }
            this.directory = newDirectory;
        } else {
            throw new IllegalArgumentException("Incorrect parameter. Can't change the directory!");
        }
    }

    public Path getFileName() {
        return fileName;
    }

    public boolean setFileName(String fileName) throws IOException {
        Path pathToFile = this.directory.resolve(this.fileName);
        if (isCorrectFileName(fileName)) {
            Path newPathToFile = this.directory.resolve(Paths.get(fileName));
            if (Files.notExists(newPathToFile)) {
                this.fileName = Paths.get(fileName);
                if (Files.exists(pathToFile)) {
                    Files.move(pathToFile, newPathToFile);
                }
                return true;
            }
        } else {
            throw new IllegalArgumentException("Incorrect parameter. Can't change the file name!");
        }
        return false;
    }

    public static boolean isCorrectDirectory(String directory) {
        return (directory != null && Pattern.compile(DIRECTORY_PATTERN).matcher(directory).matches());
    }

    public static boolean isCorrectFileName(String fileName) {
        return (fileName != null && Pattern.compile(FILE_NAME_PATTERN).matcher(fileName).matches());
    }

    private static boolean isCorrectPrefixOfName(String prefixOfName) {
        return (prefixOfName != null && Pattern.compile(PREFIX_OF_NAME_PATTERN).matcher(prefixOfName).matches());
    }

    @Override
    public String toString() {
        return "TextFile [directory: " + directory + "; file name: " + fileName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextFile other = (TextFile) o;
        return Objects.equals(directory, other.directory) &&
                Objects.equals(fileName, other.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directory, fileName);
    }
}







