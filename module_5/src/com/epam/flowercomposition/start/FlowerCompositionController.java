package com.epam.flowercomposition.start;

import com.epam.flowercomposition.entity.composition.FlowerComposition;
import com.epam.flowercomposition.entity.composition.enums.CompositionType;
import com.epam.flowercomposition.util.init.Florist;
import com.epam.flowercomposition.util.init.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class FlowerCompositionController {

    private static final int MIN_NUMBER_OF_FLOWERS = 3;
    private static final int MAX_NUMBER_OF_FLOWERS = 17;
    private static final int NUMBER_OF_COMPOSITIONS = 15;

    public static void main(String[] args) {
        List<FlowerComposition> flowerCompositions = new ArrayList<>();
        Florist florist = new Florist();
        CompositionType[] types = CompositionType.values();
        int numberOfTypes = types.length;
        for (int i = 0; i < NUMBER_OF_COMPOSITIONS; i++) {
            flowerCompositions.add(florist.completeOrder(types[RandomNumberGenerator.generate(0, numberOfTypes - 1)],
                    RandomNumberGenerator.generate(MIN_NUMBER_OF_FLOWERS, MAX_NUMBER_OF_FLOWERS)));
        }
        System.out.println("Generated flower compositions:");
        flowerCompositions.forEach(System.out::println);
    }
}
