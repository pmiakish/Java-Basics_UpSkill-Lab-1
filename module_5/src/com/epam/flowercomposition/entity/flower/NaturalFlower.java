package com.epam.flowercomposition.entity.flower;

import com.epam.flowercomposition.entity.flower.enums.FlowerColour;
import com.epam.flowercomposition.entity.flower.enums.FlowerSpecies;
import java.util.Objects;

public class NaturalFlower extends Flower {

    private final boolean isCut;

    public NaturalFlower(FlowerColour flowerColour, FlowerSpecies flowerSpecies, boolean isCut) throws
            NullPointerException {
        super(flowerColour, flowerSpecies);
        this.isCut = isCut;
    }

    @Override
    public String toString() {
        return "Natural flower [" +
                "is cut: " + isCut +
                ", colour: " + flowerColour +
                ", flower species: " + flowerSpecies +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NaturalFlower other = (NaturalFlower) o;
        return isCut == other.isCut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isCut);
    }
}
