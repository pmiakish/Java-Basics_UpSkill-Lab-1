package com.epam.aggregationandcomposition.entity.lexemes;

import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text implements Readable {

    List<Readable> header;
    List<Readable> content;

    public Text(List<Readable> header, List<Readable> content) throws LexemeLogicalException{
        if (header != null && content != null && !header.isEmpty() && !content.isEmpty()) {
            this.header = header;
            this.content = content;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't create the text object!");
        }
    }

    public void setHeader(List<Readable> header) throws LexemeLogicalException {
        if (header != null && !header.isEmpty()) {
            this.header = header;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't change the header!");
        }
    }

    public void setContent(List<Readable> content) throws LexemeLogicalException {
        if (content != null && !content.isEmpty()) {
            this.content = content;
        } else {
            throw new LexemeLogicalException("Incorrect content! Can't change the text!");
        }
    }

    public List<Readable> getHeader() {
        return header;
    }

    public List<Readable> getContent() {
        return content;
    }

    @Override
    public void addContent(String additionalContent) throws LexemeLogicalException {
        if (additionalContent != null && additionalContent.length() != 0) {
            String[] subStrings = additionalContent.split("\\s|\\b(?:(?=[\\.!\\?,;:])|(?<=[\\.!\\?,;:]))+");
            ArrayList<Readable> splitText = new ArrayList<>();
            for (String subStr : subStrings) {
                if (Word.isCorrectContent(subStr)) {
                    splitText.add(new Word(subStr));
                } else if (Punctuation.isCorrectContent(subStr)) {
                    splitText.add(new Punctuation(subStr));
                } else {
                    throw new LexemeLogicalException("Incorrect additional content! Can't change the text object!");
                }
            }
            this.content.addAll(splitText);
        } else {
            throw new LexemeLogicalException("Incorrect additional content! Can't change the text object!");
        }
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder().append(content.get(0));
        for (int i = 1; i < content.size(); i++) {
            if (!(content.get(i) instanceof Punctuation)) {
                text.append(" ").append(content.get(i));
            } else {
                text.append(content.get(i));
            }
        }
        return text.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(header, text.header) &&
                Objects.equals(content, text.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, content);
    }
}
