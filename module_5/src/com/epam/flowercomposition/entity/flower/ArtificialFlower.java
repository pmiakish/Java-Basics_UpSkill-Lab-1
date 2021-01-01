package com.epam.flowercomposition.entity.flower;

import com.epam.flowercomposition.entity.flower.enums.*;
import java.util.Objects;

public class ArtificialFlower extends Flower {

    private FlowerMaterial flowerMaterial;

    public ArtificialFlower(FlowerColour flowerColour, FlowerSpecies flowerSpecies, FlowerMaterial flowerMaterial)
            throws NullPointerException {
        super(flowerColour, flowerSpecies);
        this.flowerMaterial = Objects.requireNonNull(flowerMaterial, "The type of the flower material cannot be null!");
    }

    public FlowerMaterial getFlowerMaterial() {
        return flowerMaterial;
    }

    public void setFlowerMaterial(FlowerMaterial flowerMaterial) throws NullPointerException {
        this.flowerMaterial = Objects.requireNonNull(flowerMaterial, "The type of the flower material cannot be null!");
    }

    @Override
    public String toString() {
        return "Artificial flower [" +
                "material type: " + flowerMaterial +
                ", colour: " + flowerColour +
                ", flower species: " + flowerSpecies +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArtificialFlower other = (ArtificialFlower) o;
        return flowerMaterial == other.flowerMaterial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flowerMaterial);
    }
}
