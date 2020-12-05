package com.epam.simplestclassesandobjects.service;

import com.epam.simplestclassesandobjects.entity.Airline;
import com.epam.simplestclassesandobjects.entity.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class BookAggregator {

    private static final String[] AUTHORS = {"Sierra K.", "Bates B.", "Chan J.", "Lowe D.", "Bloch J.", "Horstmann C.",
            "Schildt H.", "Loy M.", "Evans B.J.", "Fusco M.", "Mycroft A.", "Goetz B.", "Helm R.", "Johnson R.",
            "Vlissides J.", "Booch G."};
    private static final String[] NAMES_OF_BOOKS = {"Head First Java, 2nd Edition", "Java: Learn Java in One Day " +
            "and Learn It Well", "Java All-in-One For Dummies 5th Edition", "Effective Java 3rd Edition", "Core Java " +
            "SE 9 for the Impatient 2nd Edition", "Java: A Beginner's Guide, Eighth Edition 8th Edition", "Learning " +
            "Java: An Introduction to Real-World Programming with Java 5th Edition", "Java in a Nutshell: A Desktop " +
            "Quick Reference 7th Edition", "Modern Java in Action 2nd Edition", "Java Concurrency in Practice 1st " +
            "Edition ", "Design Patterns: Elements of Reusable Object-Oriented Software 1st Edition",
            "Code Complete: A Practical Handbook of Software Construction, Second Edition 2nd Edition", "The " +
            "Pragmatic Programmer: Your Journey To Mastery, 20th Anniversary Edition", "Clean Architecture: " +
            "A Craftsman's Guide to Software Structure and Design", "Starting Out with Java: From Control Structures " +
            "through Objects", "Java Coding Problems: Improve your Java Programming skills by solving real-world " +
            "coding challenges"};
    private static final String[] PUBLISHERS = {"O'Reilly Media", "LCF Publishing", "Addison-Wesley Professional",
            "McGraw-Hill Education", "Manning Publications", "Microsoft Press", "Thomas Publishing",
            "Pearson", "Packt Publishing", "No Starch Press", "Leanpub", "The Pragmatic Bookshelf", "Peachpit", "Que"};
    private static final String[] BINDING_TYPES = {"softcover", "hardcover"};
    private static final int MIN_NUMBER_OF_AUTHORS = 1;
    private static final int MAX_NUMBER_OF_AUTHORS = 3;
    private static final int MIN_PUBLICATION_YEAR = 1990;
    private static final int MAX_PUBLICATION_YEAR = 2020;
    private static final int MIN_NUMBER_OF_PAGES = 200;
    private static final int MAX_NUMBER_OF_PAGES = 1500;
    private static final int MIN_PRICE = 100;
    private static final int MAX_PRICE = 2500;

    public static Book[] generateBookArray(int numberOfBooks) {
        Book[] books = (numberOfBooks > 0) ? new Book[numberOfBooks] : null;
        for (int i = 0; i < numberOfBooks; i++) {
            String randomBookName = NAMES_OF_BOOKS[generateRandomNumber(0, NAMES_OF_BOOKS.length - 1)];
            String[] randomAuthors = new String[generateRandomNumber(MIN_NUMBER_OF_AUTHORS, MAX_NUMBER_OF_AUTHORS)];
            for (int j = 0; j < randomAuthors.length; j++) {
                int authorIndex = generateRandomNumber(0, AUTHORS.length - 1);
                if (!Arrays.asList(randomAuthors).contains(AUTHORS[authorIndex])) {
                    randomAuthors[j] = AUTHORS[authorIndex];
                } else {
                    j--;
                }
            }
            String randomPublisher = PUBLISHERS[generateRandomNumber(0, PUBLISHERS.length - 1)];
            String randomBindingType = BINDING_TYPES[generateRandomNumber(0, BINDING_TYPES.length - 1)];
            Year randomYearOfPublication = Year.of(generateRandomNumber(MIN_PUBLICATION_YEAR, MAX_PUBLICATION_YEAR));
            int randomNumberOfPages = generateRandomNumber(MIN_NUMBER_OF_PAGES, MAX_NUMBER_OF_PAGES);
            int randomPrice = generateRandomNumber(MIN_PRICE, MAX_PRICE);

            try {
                books[i] = new Book(randomBookName, randomPublisher, randomBindingType, randomYearOfPublication,
                        randomNumberOfPages, randomPrice, randomAuthors);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                books = null;
                break;
            }
        }
        return books;
    }

    public static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static ArrayList<Book> findBooksByAuthor(Book[] books, String specifiedAuthor) {
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        for (Book book : books) {
            for (String author : book.getAuthors()) {
                if (author.equalsIgnoreCase(specifiedAuthor)) {
                    booksByAuthor.add(book);
                    break;
                }
            }
        }
        return booksByAuthor;
    }

    public static ArrayList<Book> findBooksByPublisher(Book[] books, String specifiedPublisher) {
        ArrayList<Book> booksByPublisher = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(specifiedPublisher)) {
                booksByPublisher.add(book);
            }
        }
        return booksByPublisher;
    }

    public static ArrayList<Book> findBooksPublishedAfterSpecifiedYear(Book[] books, Year specifiedYear) {
        ArrayList<Book> booksPublishedAfterSpecifiedYear = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getYearOfPublication().isAfter(specifiedYear)) {
                booksPublishedAfterSpecifiedYear.add(book);
            }
        }
        return booksPublishedAfterSpecifiedYear;
    }

    private static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
}
