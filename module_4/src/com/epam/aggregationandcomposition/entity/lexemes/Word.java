package com.epam.aggregationandcomposition.entity.lexemes;

import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements Readable {

    String content;

    Word() {
        super();
    }

    public Word(String content) throws LexemeLogicalException {
        if (isCorrectContent(content)) {
            this.content = content;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't create a word object!");
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws LexemeLogicalException {
        if (isCorrectContent(content)) {
            this.content = content;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't change the word object!");
        }
    }

    public static boolean isCorrectContent(String content) {
        if (content != null) {
            Pattern wordPattern = Pattern.compile("^[\\\\\\w'\"/-]+$");
            Matcher wordMatcher = wordPattern.matcher(content);
            return wordMatcher.matches();
        } else {
            return false;
        }
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
        Word word = (Word) o;
        return Objects.equals(content, word.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
