package com.epam.aggregationandcomposition.entity.lexemes;

import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Punctuation implements Lexeme {

    private String content;

    public Punctuation(String content) throws LexemeLogicalException {
        if (isCorrectContent(content)) {
            this.content = content;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't create a punctuation object!");
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws LexemeLogicalException {
        if (isCorrectContent(content)) {
            this.content = content;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't change the punctuation object!");
        }
    }

    public static boolean isCorrectContent(String content) {
        return Pattern.compile("^[\\.!\\?,;:]+$").matcher(String.valueOf(content)).matches();
    }

    @Override
    public void addContent(String additionalContent) throws LexemeLogicalException {
        if (isCorrectContent(additionalContent)) {
            this.content.concat(additionalContent);
        } else {
            throw new LexemeLogicalException("Incorrect additional content! Can't change the word object!");
        }
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Punctuation that = (Punctuation) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }
}
