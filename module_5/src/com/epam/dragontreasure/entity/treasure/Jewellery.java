package com.epam.dragontreasure.entity.treasure;

import com.epam.dragontreasure.entity.treasure.enums.JewelleryType;
import com.epam.dragontreasure.entity.treasure.enums.MetalType;
import java.math.BigDecimal;
import java.util.Objects;

public class Jewellery extends Treasure {

    private MetalType metalType;
    private int weight;
    private Gemstone gemstone;

    public Jewellery(JewelleryType type, int numberOfItems, MetalType metalType, int weight, Gemstone gemstone) throws
            NullPointerException, IllegalArgumentException {
        super(type, numberOfItems);
        this.metalType = Objects.requireNonNull(metalType, "The type of metal can't be null!");
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Incorrect weight value!");
        }
        this.gemstone = Objects.requireNonNull(gemstone, "The gemstone can't be null!");
    }

    public MetalType getMetalType() {
        return metalType;
    }

    public void setMetalType(MetalType metalType) {
        this.metalType = Objects.requireNonNull(metalType, "The type of metal can't be null!");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Incorrect weight value!");
        }
    }

    public Gemstone getGemstone() {
        return gemstone;
    }

    public void setGemstone(Gemstone gemstone) {
        this.gemstone = Objects.requireNonNull(gemstone, "The gemstone can't be null!");
    }

    @Override
    public BigDecimal calculatePrice() {
        return metalType.getPricePerStandartUnit().multiply(BigDecimal.valueOf(weight).add(gemstone.calculatePrice()));
    }

    @Override
    public String toString() {
        return "Jewellery {" +
                "type: " + type +
                "; metal type: " + metalType +
                "; weight: " + weight + "g" +
                "; gemstone: " + gemstone.getType() + ", " + gemstone.getWeight() + "ct" +
                "; number of items: " + numberOfItems +
                "; price: " + calculatePrice() +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jewellery other = (Jewellery) o;
        return weight == other.weight &&
                type == other.type &&
                numberOfItems == other.numberOfItems &&
                metalType == other.metalType &&
                gemstone.equals(other.gemstone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, type, numberOfItems, metalType, gemstone);
    }
}
