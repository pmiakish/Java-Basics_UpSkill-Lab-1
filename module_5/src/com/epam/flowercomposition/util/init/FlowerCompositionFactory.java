package com.epam.flowercomposition.util.init;

import com.epam.flowercomposition.entity.composition.FlowerComposition;

public interface FlowerCompositionFactory {
    FlowerComposition createFlowerComposition(int numberOfFlowers);
}
