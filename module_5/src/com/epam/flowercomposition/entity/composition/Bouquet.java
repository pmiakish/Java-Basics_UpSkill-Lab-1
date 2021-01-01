package com.epam.flowercomposition.entity.composition;

import com.epam.flowercomposition.entity.composition.enums.BouquetType;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;
import java.util.Objects;

public class Bouquet extends FlowerComposition {

    private BouquetType bouquetType;

    public Bouquet(List<Flower> flowers, Pack pack, String name, BouquetType bouquetType) throws NullPointerException,
            IllegalArgumentException {
        super(flowers, pack, name);
        this.bouquetType = Objects.requireNonNull(bouquetType, "The bouquet type cannot be null!");
    }

    public BouquetType getBouquetType() {
        return bouquetType;
    }

    public void setBouquetType(BouquetType bouquetType) throws NullPointerException {
        this.bouquetType = Objects.requireNonNull(bouquetType, "The bouquet type cannot be null!");
    }

    @Override
    public String toString() {
        return "Bouquet {" +
                "name: \"" + name +
                "\", bouquet type: " + bouquetType +
                ", (flowers: " + flowers +
                "), (pack: " + pack +
                ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bouquet other = (Bouquet) o;
        return bouquetType == other.bouquetType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bouquetType);
    }
}
