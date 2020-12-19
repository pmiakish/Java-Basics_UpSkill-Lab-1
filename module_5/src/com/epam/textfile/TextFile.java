package com.epam.textfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class TextFile {

    private static int counterId = 0;
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

    public boolean create() throws IOException {
        Path pathToFile = directory.resolve(fileName);
        if (Files.exists(pathToFile)) {
            return false;
        }
        if (Files.notExists(directory)) {
            Files.createDirectories(directory);
        }
        Files.createFile(pathToFile);
        return true;
    }

    public boolean delete() throws IOException {
        Path pathToFile = directory.resolve(fileName);
        if (Files.exists(pathToFile)) {
            Files.delete(pathToFile);
            return true;
        }
        return false;
    }

    public List<String> read() throws IOException {
        List<String> fileLines = null;
        Path pathToFile = directory.resolve(fileName);
        if (Files.exists(pathToFile) && Files.isReadable(pathToFile)) {
            fileLines = Files.readAllLines(pathToFile);
        }
        return fileLines;
    }

    public boolean write(String str) throws IOException {
        Path pathToFile = directory.resolve(fileName);
        if (Files.exists(pathToFile) && Files.isWritable(pathToFile) && str != null) {
            Files.writeString(pathToFile, str, StandardOpenOption.APPEND);
            return true;
        }
        return false;
    }

    public boolean rename(String directory, String fileName) throws IOException {
        Path pathToFile = this.directory.resolve(this.fileName);
        if (isCorrectDirectory(directory) && isCorrectFileName(fileName)) {
            Path newDirectory = Paths.get(directory);
            Path newPathToFile = Paths.get(directory, fileName);
            if (Files.notExists(newPathToFile)) {
                if (Files.notExists(newDirectory)) {
                    Files.createDirectories(newDirectory);
                }
                Files.move(pathToFile, newPathToFile);
                this.directory = newDirectory;
                this.fileName = Paths.get(fileName);
                return true;
            }
        }
        return false;
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

    private boolean isCorrectDirectory(String directory) {
        return (directory != null && Pattern.compile("^(?:[\\w-]+\\\\)+$").matcher(directory).matches());
    }

    private boolean isCorrectPrefixOfName(String prefixOfName) {
        return (prefixOfName != null && Pattern.compile("^[\\w-]+$").matcher(prefixOfName).matches());
    }

    private boolean isCorrectFileName(String fileName) {
        return (fileName != null && Pattern.compile("^[\\w-]+\\.[A-Za-z0-9]+$").matcher(fileName).matches());
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







