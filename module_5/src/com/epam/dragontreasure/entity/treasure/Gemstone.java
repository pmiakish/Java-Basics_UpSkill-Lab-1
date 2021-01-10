package com.epam.dragontreasure.entity.treasure;

import com.epam.dragontreasure.entity.treasure.enums.GemstoneType;
import java.math.BigDecimal;
import java.util.Objects;

public class Gemstone extends Treasure {

    private static final double CORRECTION_RATIO = 2.0;

    private int weight;
    private boolean isFaceted;

    public Gemstone(GemstoneType type, int numberOfItems, int weight, boolean isFaceted) throws NullPointerException,
            IllegalArgumentException {
        super(type, numberOfItems);
        this.isFaceted = isFaceted;
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Incorrect weight value!");
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalArgumentException {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Incorrect weight value!");
        }
    }

    public boolean isFaceted() {
        return isFaceted;
    }

    public void setFaceted(boolean faceted) {
        isFaceted = faceted;
    }

    @Override
    public BigDecimal calculatePrice() {
        return (isFaceted) ? ((GemstoneType)type).getPricePerStandartUnit().multiply(BigDecimal.valueOf(weight)).
                multiply(BigDecimal.valueOf(CORRECTION_RATIO)) : ((GemstoneType)type).getPricePerStandartUnit().
                multiply(BigDecimal.valueOf(weight));
    }

    @Override
    public String toString() {
        return "Gemstone {" +
                "type: " + type +
                "; weight: " + weight + "ct" +
                "; is faceted: " + isFaceted +
                "; number of items: " + numberOfItems +
                "; price: " + calculatePrice() +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gemstone other = (Gemstone) o;
        return weight == other.weight &&
                isFaceted == other.isFaceted &&
                type == other.type &&
                numberOfItems == other.numberOfItems;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, isFaceted, type, numberOfItems);
    }

}
