package com.epam.flowercomposition.entity.flower;

import com.epam.flowercomposition.entity.flower.enums.FlowerColour;
import com.epam.flowercomposition.entity.flower.enums.FlowerSpecies;
import java.util.Objects;

public abstract class Flower {

    protected FlowerColour flowerColour;
    protected FlowerSpecies flowerSpecies;

    protected Flower(FlowerColour flowerColour, FlowerSpecies flowerSpecies) throws NullPointerException {
        this.flowerColour = Objects.requireNonNull(flowerColour, "The colour of the flower cannot be null!");
        this.flowerSpecies = Objects.requireNonNull(flowerSpecies, "The type of the flower cannot be null!");
    }

    public FlowerColour getColour() {
        return flowerColour;
    }

    public void setColour(FlowerColour flowerColour) throws NullPointerException {
        this.flowerColour = Objects.requireNonNull(flowerColour, "The colour of the flower cannot be null!");
    }

    public FlowerSpecies getFlowerType() {
        return flowerSpecies;
    }

    public void setFlowerType(FlowerSpecies flowerSpecies) throws NullPointerException {
        this.flowerSpecies = Objects.requireNonNull(flowerSpecies, "The type of the flower cannot be null!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower other = (Flower) o;
        return flowerColour == other.flowerColour &&
                flowerSpecies == other.flowerSpecies;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerColour, flowerSpecies);
    }
}
