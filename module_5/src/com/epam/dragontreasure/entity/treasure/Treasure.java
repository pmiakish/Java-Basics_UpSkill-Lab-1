package com.epam.dragontreasure.entity.treasure;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Treasure implements Comparable<Treasure> {

    protected Enum type;
    protected int numberOfItems;

    protected Treasure(Enum type, int numberOfItems) throws NullPointerException, IllegalArgumentException {
        this.type = Objects.requireNonNull(type, "A type of the treasure can't be null!");
        if (numberOfItems > 0) {
            this.numberOfItems = numberOfItems;
        } else {
            throw new IllegalArgumentException("Incorrect number of items!");
        }
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) throws IllegalArgumentException {
        if (numberOfItems > 0) {
            this.numberOfItems = numberOfItems;
        } else {
            throw new IllegalArgumentException("Incorrect number of items!");
        }
    }

    public abstract BigDecimal calculatePrice();

    @Override
    public int compareTo(Treasure other) {
        return this.calculatePrice().compareTo(other.calculatePrice());
    }

}