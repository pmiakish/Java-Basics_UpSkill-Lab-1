package com.epam.aggregationandcomposition.entity.lexemes;

import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Sentence implements Lexeme {

    private List<Lexeme> content;

    public Sentence(List<Lexeme> content) throws LexemeLogicalException {
        if (isCorrectContent(content)) {
            this.content = new ArrayList<>(content);
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't create a sentence object!");
        }
    }

    public List<Lexeme> getContent() {
        return content;
    }

    public void setContent(List<Lexeme> content) throws LexemeLogicalException{
        if (isCorrectContent(content)) {
            this.content = new ArrayList<>(content);
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't change a sentence object!");
        }
    }

    private boolean isCorrectContent(List<Lexeme> content) {
        if (content != null && !content.isEmpty()) {
            if (Pattern.compile("^[\\\\\\w'\"/-]+$").matcher(String.valueOf(content.get(0))).matches() &&
                    Pattern.compile("^[\\.!\\?]+$").matcher(String.valueOf(content.get(content.size()-1))).matches()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addContent(String additionalContent) throws LexemeLogicalException {
        if (Word.isCorrectContent(additionalContent)) {
            this.content.add(new Word(additionalContent));
        } else if (Punctuation.isCorrectContent(additionalContent)) {
            this.content.add(new Punctuation(additionalContent));
        } else {
            throw new LexemeLogicalException("Incorrect additional content! Can't change the sentence object!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder().append(content.get(0));
        for (int i = 1; i < content.size(); i++) {
            if (!(content.get(i) instanceof Punctuation)) {
                sentence.append(" ").append(content.get(i));
            } else {
                sentence.append(content.get(i));
            }
        }
        return sentence.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(content, sentence.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
