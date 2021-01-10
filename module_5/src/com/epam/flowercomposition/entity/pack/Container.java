package com.epam.flowercomposition.entity.pack;

import com.epam.flowercomposition.entity.pack.enums.PackColour;
import com.epam.flowercomposition.entity.pack.enums.ContainerMaterial;
import com.epam.flowercomposition.entity.pack.enums.PackSize;
import java.util.Objects;

public class Container extends Pack {

    private PackSize packSize;
    private boolean isEquippedWithIrrigationSystem;

    public Container(PackColour packColour, ContainerMaterial containerMaterial, PackSize packSize, boolean
            isEquippedWithIrrigationSystem) throws NullPointerException {
        super(packColour, containerMaterial);
        this.packSize = Objects.requireNonNull(packSize, "The flowerpot size cannot be null!");
        this.isEquippedWithIrrigationSystem = isEquippedWithIrrigationSystem;
    }

    public PackSize getPackSize() {
        return packSize;
    }

    public void setPackSize(PackSize packSize) throws NullPointerException {
        this.packSize = Objects.requireNonNull(packSize, "The flowerpot size cannot be null!");
    }

    public boolean isEquippedWithIrrigationSystem() {
        return isEquippedWithIrrigationSystem;
    }

    public void setEquippedWithIrrigationSystem(boolean equippedWithIrrigationSystem) {
        isEquippedWithIrrigationSystem = equippedWithIrrigationSystem;
    }

    @Override
    public String toString() {
        return "Container [" +
                "size: " + packSize +
                ", is equipped with an irrigation system: " + isEquippedWithIrrigationSystem +
                ", colour: " + packColour +
                ", pack type: " + packType +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Container other = (Container) o;
        return isEquippedWithIrrigationSystem == other.isEquippedWithIrrigationSystem &&
                packSize == other.packSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packSize, isEquippedWithIrrigationSystem);
    }
}
