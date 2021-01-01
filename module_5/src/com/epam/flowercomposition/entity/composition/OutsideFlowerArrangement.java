package com.epam.flowercomposition.entity.composition;

import com.epam.flowercomposition.entity.composition.enums.SoilType;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;
import java.util.Objects;

public class OutsideFlowerArrangement extends FlowerComposition {

    private SoilType soilType;

    public OutsideFlowerArrangement(List<Flower> flowers, Pack pack, String name, SoilType soilType) throws
            NullPointerException, IllegalArgumentException {
        super(flowers, pack, name);
        this.soilType = Objects.requireNonNull(soilType, "The soil type cannot be null!");
    }

    public SoilType soilType() {
        return soilType;
    }

    public void setSoilType(SoilType soilType) throws NullPointerException {
        this.soilType = Objects.requireNonNull(soilType, "The soil type cannot be null!");
    }

    @Override
    public String toString() {
        return "Outside flower arrangement {" +
                "name: \"" + name +
                "\", soil type: " + soilType +
                ", (flowers: " + flowers +
                "), (pack: " + pack +
                ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutsideFlowerArrangement other = (OutsideFlowerArrangement) o;
        return soilType == other.soilType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), soilType);
    }
}
