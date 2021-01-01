package com.epam.flowercomposition.util.init;

import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.entity.composition.InteriorFlowerArrangement;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.FlowerPot;
import java.util.List;

public class InteriorFlowerArrangementFactory implements FlowerCompositionFactory {

    FlowerComposition interiorFlowerArrangement;

    @Override
    public FlowerComposition createFlowerComposition(int numberOfFlowers) throws NullPointerException,
            IllegalArgumentException {
        if (numberOfFlowers > 0) {
            List<Flower> flowers = FlowerCompositionInitializer.createListOfArtificialFlowers(numberOfFlowers);
            FlowerPot pack = FlowerCompositionInitializer.createFlowerPot(numberOfFlowers);
            String name = FlowerCompositionInitializer.defineRandomName();
            interiorFlowerArrangement = new InteriorFlowerArrangement(flowers, pack, name);
        } else {
            throw new IllegalArgumentException("Incorrect number of flowers! Cannot create an interior flower " +
                    "arrangement.");
        }
        return interiorFlowerArrangement;
    }

}
