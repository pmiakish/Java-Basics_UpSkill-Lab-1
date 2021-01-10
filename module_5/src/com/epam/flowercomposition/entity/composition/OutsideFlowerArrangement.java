package com.epam.flowercomposition.entity.composition;

import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import com.epam.flowercomposition.entity.pack.enums.ContainerMaterial;

import java.util.List;

public class OutsideFlowerArrangement extends FlowerComposition {

    private static final int MIN_NUMBER_OF_FLOWERS_IN_EXPENSIVE_SECTION = 45;

    public OutsideFlowerArrangement(List<Flower> flowers, Pack pack, String name) throws NullPointerException,
            IllegalArgumentException {
        super(flowers, pack, name);
    }

    @Override
    public boolean checkBelongingToExpensiveSection() {
        return (flowers.size() > MIN_NUMBER_OF_FLOWERS_IN_EXPENSIVE_SECTION &&
                this.pack.getPackType() == ContainerMaterial.STONE);
    }

    @Override
    public String toString() {
        return "Outside flower arrangement {" + super.toString();
    }

}
