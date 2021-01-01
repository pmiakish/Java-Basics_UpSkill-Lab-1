package com.epam.flowercomposition.entity.pack;

import com.epam.flowercomposition.entity.pack.enums.PackColour;
import com.epam.flowercomposition.entity.pack.enums.PackSize;
import com.epam.flowercomposition.entity.pack.enums.FlowerPotMaterial;
import java.util.Objects;

public class FlowerPot extends Pack {

    private PackSize packSize;

    public FlowerPot(PackColour packColour, FlowerPotMaterial flowerPotMaterial, PackSize packSize) throws
            NullPointerException {
        super(packColour, flowerPotMaterial);
        this.packSize = Objects.requireNonNull(packSize, "The flowerpot size cannot be null!");
    }

    public PackSize getPackSize() {
        return packSize;
    }

    public void setPackSize(PackSize packSize) throws NullPointerException {
        this.packSize = Objects.requireNonNull(packSize, "The flowerpot size cannot be null!");
    }

    @Override
    public String toString() {
        return "Flowerpot [" +
                "size: " + packSize +
                ", colour: " + packColour +
                ", pack type: " + packType +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlowerPot other = (FlowerPot) o;
        return packSize == other.packSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packSize);
    }
}
