package com.epam.aggregationandcomposition.entity.lexemes;

import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Punctuation extends Word{

    String content;

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

    public static boolean isCorrectContent(String content) {
        Pattern punctuationPattern = Pattern.compile("^[\\.!\\?,;:]+$");
        Matcher punctuationMatcher = punctuationPattern.matcher(String.valueOf(content));
        return punctuationMatcher.matches();
    }

    @Override
    public void addContent(String additionalContent) {

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
