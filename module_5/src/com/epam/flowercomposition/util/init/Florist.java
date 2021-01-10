package com.epam.flowercomposition.util.init;

import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.entity.composition.enums.CompositionType;
import com.epam.flowercomposition.entity.factory.BouquetFactory;
import com.epam.flowercomposition.entity.factory.FlowerCompositionFactory;
import com.epam.flowercomposition.entity.factory.InteriorFlowerArrangementFactory;
import com.epam.flowercomposition.entity.factory.OutsideFlowerArrangementFactory;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;

public class Florist {

    public FlowerComposition completeOrder(CompositionType compositionType, int numberOfFlowers) throws
            NullPointerException, IllegalArgumentException {
        FlowerCompositionFactory factory;
        List<Flower> flowers;
        Pack pack;
        String compositionName;
        if (numberOfFlowers > 0) {
            switch (compositionType) {
                case BOUQUET:
                    flowers = FlowerCompositionInitializer.createListOfNaturalFlowers(numberOfFlowers, true);
                    pack = FlowerCompositionInitializer.createBouquetPackaging();
                    compositionName = FlowerCompositionInitializer.defineRandomName();
                    factory = new BouquetFactory();
                    break;
                case INTERIOR_FLOWER_ARRANGEMENT:
                    flowers = FlowerCompositionInitializer.createListOfNaturalFlowers(numberOfFlowers, false);
                    pack = FlowerCompositionInitializer.createFlowerPot(numberOfFlowers);
                    compositionName = FlowerCompositionInitializer.defineRandomName();
                    factory = new InteriorFlowerArrangementFactory();
                    break;
                case OUTSIDE_FLOWER_ARRANGEMENT:
                    flowers = FlowerCompositionInitializer.createListOfArtificialFlowers(numberOfFlowers);
                    pack = FlowerCompositionInitializer.createContainer(numberOfFlowers);
                    compositionName = FlowerCompositionInitializer.defineRandomName();
                    factory = new OutsideFlowerArrangementFactory();
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect type of a flower composition!");
            }
        } else {
            throw new IllegalArgumentException("Incorrect number of flowers!");
        }
        return factory.createFlowerComposition(flowers, pack, compositionName);
    }

}
