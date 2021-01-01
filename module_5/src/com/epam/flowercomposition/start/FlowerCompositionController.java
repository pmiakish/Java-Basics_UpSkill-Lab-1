package com.epam.flowercomposition.start;

import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.util.init.BouquetFactory;
import com.epam.flowercomposition.util.init.InteriorFlowerArrangementFactory;
import com.epam.flowercomposition.util.init.OutsideFlowerArrangementFactory;
import com.epam.flowercomposition.util.init.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class FlowerCompositionController {

    private static final int MIN_NUMBER_OF_FLOWERS = 3;
    private static final int MAX_NUMBER_OF_FLOWERS = 17;
    private static final int NUMBER_OF_COMPOSITIONS = 5;

    public static void main(String[] args) {
        List<FlowerComposition> flowerCompositions = new ArrayList<>();
        BouquetFactory bouquetFactory = new BouquetFactory();
        InteriorFlowerArrangementFactory interiorFlowerArrangementFactory = new InteriorFlowerArrangementFactory();
        OutsideFlowerArrangementFactory outsideFlowerArrangementFactory = new OutsideFlowerArrangementFactory();
        for (int i = 0; i < NUMBER_OF_COMPOSITIONS; i++) {
            flowerCompositions.add(bouquetFactory.createFlowerComposition(RandomNumberGenerator.
                    generate(MIN_NUMBER_OF_FLOWERS, MAX_NUMBER_OF_FLOWERS)));
        }
        for (int i = 0; i < NUMBER_OF_COMPOSITIONS; i++) {
            flowerCompositions.add(interiorFlowerArrangementFactory.createFlowerComposition(RandomNumberGenerator.
                    generate(MIN_NUMBER_OF_FLOWERS, MAX_NUMBER_OF_FLOWERS)));
        }
        for (int i = 0; i < NUMBER_OF_COMPOSITIONS; i++) {
            flowerCompositions.add(outsideFlowerArrangementFactory.createFlowerComposition(RandomNumberGenerator.
                    generate(MIN_NUMBER_OF_FLOWERS, MAX_NUMBER_OF_FLOWERS)));
        }
        System.out.println("Generated flower compositions:");
        flowerCompositions.forEach(System.out::println);
    }
}
