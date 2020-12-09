package com.epam.aggregationandcomposition.entity.lexemes;

import com.epam.aggregationandcomposition.exceptions.LexemeLogicalException;

public interface Readable {
    void addContent(String additionalContent) throws LexemeLogicalException;
}
