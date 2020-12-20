package com.epam.textfile.service;

import com.epam.textfile.entity.TextFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFileController {

    private static final String DIRECTORY_1 = "text_files\\dir\\";
    private static final String DIRECTORY_2 = "text_files\\dir\\renamed\\";
    private static final String PREFIX_OF_NAME = "text";
    private static final String SECOND_NAME_OF_FILE = "renamed_file.TXT";
    private static final String STR_FOR_WRITING = "String ...\n";

    public static void main(String[] args) {
        try {
            Files.deleteIfExists(Paths.get(DIRECTORY_2, SECOND_NAME_OF_FILE));

            TextFile textFile = new TextFile(DIRECTORY_1, PREFIX_OF_NAME);
            System.out.println("The first text file has been created: " + TextFileWorker.create(textFile) + "\ninfo: "
                    + textFile);

            if (TextFileWorker.write(textFile, STR_FOR_WRITING)) {
                System.out.println("\nThe specified string has been written to " + textFile.getFileName());
            } else {
                System.out.println("\nCan't write to " + textFile.getFileName());
            }

            List<String> content = TextFileWorker.read(textFile);
            if (content != null) {
                System.out.println("The file " + textFile.getFileName() + " contents:");
                content.forEach(System.out::println);
            } else {
                System.out.println("Can't read the file " + textFile.getFileName());
            }

            textFile.setDirectory(DIRECTORY_2);
            textFile.setFileName(SECOND_NAME_OF_FILE);
            System.out.println("\nThe first text file has been renamed (replaced)\ninfo: " + textFile);

            TextFile secondTextFile = new TextFile(DIRECTORY_1, PREFIX_OF_NAME);
            System.out.println("\nThe second text file has been created: " + TextFileWorker.create(secondTextFile) +
                    "\ninfo: " + secondTextFile);

            if (TextFileWorker.delete(secondTextFile)) {
                System.out.println("\nThe second text file has been deleted");
            } else {
                System.out.println("\nCan't delete the file!");
            }

        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
