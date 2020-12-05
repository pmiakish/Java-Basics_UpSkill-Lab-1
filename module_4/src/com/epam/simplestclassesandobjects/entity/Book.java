package com.epam.simplestclassesandobjects.entity;

import java.time.Year;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {

    private final int id;
    private static int counterId = 1;
    private String bookName;
    private String[] authors;
    private String publisher;
    private String bindingType;
    private Year yearOfPublication;
    private int numberOfPages;
    private int price;

    public Book(String bookName, String publisher, String bindingType, Year yearOfPublication,
            int numberOfPages, int price, String ...authors) throws IllegalArgumentException {
        if (isCorrectName(true, authors) &&
                isCorrectName(false, bookName, publisher) &&
                (bindingType.equalsIgnoreCase("softcover") || bindingType.equalsIgnoreCase("hardcover")) &&
                !yearOfPublication.isAfter(Year.now()) &&
                numberOfPages > 0 &&
                price >= 0) {
            id = counterId++;
            this.bookName = bookName;
            this.authors = new String[authors.length];
            System.arraycopy(authors, 0, this.authors, 0, authors.length);
            this.publisher = publisher;
            this.bindingType = bindingType;
            this.yearOfPublication = yearOfPublication;
            this.numberOfPages = numberOfPages;
            this.price = price;
        } else {
            throw new IllegalArgumentException("Wrong values of book fields! The book wasn't create!");
        }
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) throws IllegalArgumentException {
        if (isCorrectName(false, bookName)) {
            this.bookName = bookName;
        } else {
            throw new IllegalArgumentException("Incorrect book name! Can't change the field!");
        }
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String ...authors) throws IllegalArgumentException {
        if (isCorrectName(true, authors)) {
            this.authors = new String[authors.length];
            System.arraycopy(authors, 0, this.authors, 0, authors.length);
        } else {
            throw new IllegalArgumentException("Incorrect names of authors! Can't change the field!");
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws IllegalArgumentException {
        if (isCorrectName(false, publisher)) {
            this.publisher = publisher;
        } else {
            throw new IllegalArgumentException("Incorrect publisher name! Can't change the field!");
        }
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) throws IllegalArgumentException {
        if (bindingType.equalsIgnoreCase("softcover") || bindingType.equalsIgnoreCase("hardcover")) {
            this.bindingType = bindingType;
        } else {
            throw new IllegalArgumentException("Incorrect binding type! Can't change the field!");
        }
    }

    public Year getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Year yearOfPublication) throws IllegalArgumentException {
        if (!yearOfPublication.isAfter(Year.now())) {
            this.yearOfPublication = yearOfPublication;
        } else {
            throw new IllegalArgumentException("Incorrect value of publication year! Can't change the field!");
        }
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) throws IllegalArgumentException {
        if (numberOfPages > 0) {
            this.numberOfPages = numberOfPages;
        } else {
            throw new IllegalArgumentException("Incorrect number of pages! Can't change the field!");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >=0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Incorrect price! Can't change the field!");
        }
    }

    // checking of arguments
    private boolean isCorrectName(boolean isAuthor, String ...names) {
        Pattern namePattern = (isAuthor) ? Pattern.compile("[A-Za-z-\\. ]+") : Pattern.compile("[^\\n\\t\\f\\v\\r]+");
        for (String name : names) {
            if (name == null) {
                return false;
            } else {
                Matcher nameMatcher = namePattern.matcher(name);
                if (!nameMatcher.matches()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book [" +
                "id: " + id +
                "; book name: " + bookName +
                "; authors: " + Arrays.toString(authors) +
                "; publisher: " + publisher +
                "; binding type: " + bindingType +
                "; year of publication: " + yearOfPublication +
                "; number of pages: " + numberOfPages +
                "; price: " + price +
                "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return id == other.id &&
                numberOfPages == other.numberOfPages &&
                price == other.price &&
                bookName.equals(other.bookName) &&
                Arrays.equals(authors, other.authors) &&
                publisher.equals(other.publisher) &&
                bindingType.equals(other.bindingType) &&
                yearOfPublication.equals(other.yearOfPublication);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, bookName, publisher, bindingType, yearOfPublication, numberOfPages, price);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

}
