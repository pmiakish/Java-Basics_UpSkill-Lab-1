package com.epam.flowercomposition.entity.composition;

import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;

public class Bouquet extends FlowerComposition {

    private static final int MIN_NUMBER_OF_FLOWERS_IN_EXPENSIVE_SECTION = 25;

    public Bouquet(List<Flower> flowers, Pack pack, String name) throws NullPointerException, IllegalArgumentException {
        super(flowers, pack, name);
    }

    @Override
    public boolean checkBelongingToExpensiveSection() {
        return (flowers.size() > MIN_NUMBER_OF_FLOWERS_IN_EXPENSIVE_SECTION);
    }

    @Override
    public String toString() {
        return "Bouquet {" + super.toString();
    }

}
