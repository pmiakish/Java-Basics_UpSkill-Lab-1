package com.epam.dragontreasure.entity.treasure;

import com.epam.dragontreasure.entity.treasure.enums.MetalType;
import java.math.BigDecimal;
import java.util.Objects;

public class Ingot extends Treasure {

    private int weight;

    public Ingot(MetalType type, int numberOfItems, int weight) throws NullPointerException, IllegalArgumentException {
        super(type, numberOfItems);
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

    @Override
    public BigDecimal calculatePrice() {
        return ((MetalType)type).getPricePerStandartUnit().multiply(BigDecimal.valueOf(weight));
    }

    @Override
    public String toString() {
        return "Ingot {" +
                "type: " + type +
                "; weight: " + weight + "g" +
                "; number of items: " + numberOfItems +
                "; price: " + calculatePrice() +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingot other = (Ingot) o;
        return weight == other.weight &&
                type == other.type &&
                numberOfItems == other.numberOfItems;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, type, numberOfItems);
    }
}
