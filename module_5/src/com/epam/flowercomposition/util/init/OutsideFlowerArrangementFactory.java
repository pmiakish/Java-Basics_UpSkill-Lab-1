package com.epam.flowercomposition.util.init;

import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.entity.composition.OutsideFlowerArrangement;
import com.epam.flowercomposition.entity.composition.enums.SoilType;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Container;

import java.util.List;

public class OutsideFlowerArrangementFactory implements FlowerCompositionFactory {

    FlowerComposition outsideFlowerArrangement;

    @Override
    public FlowerComposition createFlowerComposition(int numberOfFlowers) throws NullPointerException,
            IllegalArgumentException {
        if (numberOfFlowers > 0) {
            List<Flower> flowers = FlowerCompositionInitializer.createListOfNaturalFlowers(numberOfFlowers, false);
            Container pack = FlowerCompositionInitializer.createContainer(numberOfFlowers);
            String name = FlowerCompositionInitializer.defineRandomName();
            SoilType soilType = FlowerCompositionInitializer.defineRandomSoilType();
            outsideFlowerArrangement = new OutsideFlowerArrangement(flowers, pack, name, soilType);
        } else {
            throw new IllegalArgumentException("Incorrect number of flowers! Cannot create an outside flower " +
                    "arrangement.");
        }
        return outsideFlowerArrangement;
    }

}
