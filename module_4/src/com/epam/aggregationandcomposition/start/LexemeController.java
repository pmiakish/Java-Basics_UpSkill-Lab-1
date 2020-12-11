package com.epam.aggregationandcomposition.start;

import com.epam.aggregationandcomposition.entity.lexemes.Readable;
import com.epam.aggregationandcomposition.entity.lexemes.*;
import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;

import java.util.ArrayList;

public class LexemeController {

    private static final String[] WORDS_PART1 = {"Java", "is", "a", "set", "of", "computer", "software", "and",
            "specifications", "developed", "by", "James", "Gosling", "at", "Sun", "Microsystems"};
    private static final String[] WORDS_PART2 = {"The", "Oracle", "Corporation", "provides", "a", "system", "for",
            "developing", "application", "software"};
    private static final String[] WORDS_PART3 = {"deploying", "it", "in", "a", "cross-platform", "computing",
            "environment"};
    private static final String[] WORDS_PART4 = {"Java", "is", "used", "in", "a", "wide", "variety", "of",
            "computing", "platforms"};
    private static final String[] PUNCTUATION = {".", ","};
    private static final String ADDITIONAL_TEXT = "Java is the best!";

    public static void main(String[] args) {

        // --- TASK 01 ---
        try {
            Readable dot = new Punctuation(PUNCTUATION[0]);
            Readable comma = new Punctuation(PUNCTUATION[1]);

            ArrayList<Readable> lexemesForSentence1 = new ArrayList<>();
            for (String str : WORDS_PART1) {
                lexemesForSentence1.add(new Word(str));
            }
            lexemesForSentence1.add(dot);

            ArrayList<Readable> lexemesForSentence2 = new ArrayList<>();
            for (String str : WORDS_PART2) {
                lexemesForSentence2.add(new Word(str));
            }
            lexemesForSentence2.add(comma);

            for (String str : WORDS_PART3) {
                lexemesForSentence2.add(new Word(str));
            }
            lexemesForSentence2.add(dot);

            ArrayList<Readable> wordLexemes = new ArrayList<>();
            for (String str : WORDS_PART4) {
                wordLexemes.add(new Word(str));
            }

            Readable sentence1 = new Sentence(lexemesForSentence1);
            Readable sentence2 = new Sentence(lexemesForSentence2);

            ArrayList<Readable> lexemesForText = new ArrayList<>();
            lexemesForText.add(sentence1);
            lexemesForText.add(sentence2);
            lexemesForText.addAll(wordLexemes);
            lexemesForText.add(dot);
            lexemesForSentence1.add(dot);
            ArrayList<Readable> header = new ArrayList<>();
            header.add(new Word(WORDS_PART1[0]));

            Text text = new Text(header, lexemesForText);
            text.addContent(ADDITIONAL_TEXT);
            System.out.println(text.getHeader().toString() + "\n" + text);

        } catch (LexemeLogicalException e) {
            e.printStackTrace();
        }

    }

}
