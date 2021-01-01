package com.epam.flowercomposition.entity.composition;

import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;
import java.util.Objects;

public class InteriorFlowerArrangement extends FlowerComposition {

    public InteriorFlowerArrangement(List<Flower> flowers, Pack pack, String name) throws NullPointerException,
            IllegalArgumentException {
        super(flowers, pack, name);
    }

    @Override
    public String toString() {
        return "Interior flower arrangement {" +
                "name: \"" + name +
                "\", (flowers: " + flowers +
                "), (pack: " + pack +
                ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

}
