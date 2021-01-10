package com.epam.flowercomposition.entity.factory;

import com.epam.flowercomposition.entity.composition.Bouquet;
import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;

public class BouquetFactory implements FlowerCompositionFactory {

    @Override
    public FlowerComposition createFlowerComposition(List<Flower> flowers, Pack pack, String name) throws
            NullPointerException, IllegalArgumentException {
        return new Bouquet(flowers, pack, name);
    }

}
