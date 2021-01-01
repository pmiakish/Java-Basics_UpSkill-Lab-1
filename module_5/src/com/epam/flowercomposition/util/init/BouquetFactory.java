package com.epam.flowercomposition.util.init;

import com.epam.flowercomposition.entity.composition.Bouquet;
import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.entity.composition.enums.BouquetType;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.BouquetPackaging;
import java.util.List;

public class BouquetFactory implements FlowerCompositionFactory {

    FlowerComposition bouquet;

    @Override
    public FlowerComposition createFlowerComposition(int numberOfFlowers) throws NullPointerException,
            IllegalArgumentException {
        if (numberOfFlowers > 0) {
            List<Flower> flowers = FlowerCompositionInitializer.createListOfNaturalFlowers(numberOfFlowers,
                    true);
            BouquetPackaging pack = FlowerCompositionInitializer.createBouquetPackaging();
            String name = FlowerCompositionInitializer.defineRandomName();
            BouquetType bouquetType = FlowerCompositionInitializer.defineRandomBouquetType();
            bouquet = new Bouquet(flowers, pack, name, bouquetType);
        } else {
            throw new IllegalArgumentException("Incorrect number of flowers! Cannot create a bouquet.");
        }
        return bouquet;
    }

}
