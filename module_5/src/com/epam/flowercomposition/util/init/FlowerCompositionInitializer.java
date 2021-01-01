package com.epam.flowercomposition.util.init;

import com.epam.flowercomposition.entity.composition.enums.BouquetType;
import com.epam.flowercomposition.entity.composition.enums.SoilType;
import com.epam.flowercomposition.entity.flower.ArtificialFlower;
import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.flower.NaturalFlower;
import com.epam.flowercomposition.entity.flower.enums.FlowerColour;
import com.epam.flowercomposition.entity.flower.enums.FlowerSpecies;
import com.epam.flowercomposition.entity.flower.enums.FlowerMaterial;
import com.epam.flowercomposition.entity.pack.BouquetPackaging;
import com.epam.flowercomposition.entity.pack.Container;
import com.epam.flowercomposition.entity.pack.FlowerPot;
import com.epam.flowercomposition.entity.pack.enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlowerCompositionInitializer {

    private static final String[] NAMES_OF_COMPOSITIONS = {"Fall in New England", "Cherry blossom", "Stylish spring",
            "Meadow fresh", "Summer breeze", "Be my Valentine", "Evelyn", "Heaven scent", "Summer glow",
            "Summer holiday", "Cool Breeze", "Midsummer night's dream", "Spring morning", "Harvest time",
            "Christmas star", "With sympathy", "Dreamland", "Sweet success", "Starburst"};

    public static List<Flower> createListOfNaturalFlowers(int numberOfFlowers, boolean isCut) {
        List<Flower> flowers = new ArrayList<>();
        FlowerColour[] colours = FlowerColour.values();
        int numberOfColours = colours.length;
        FlowerSpecies[] species = FlowerSpecies.values();
        int numberOfSpecies = species.length;
        for (int i = 0; i < numberOfFlowers; i++) {
            flowers.add(new NaturalFlower(colours[RandomNumberGenerator.generate(0, numberOfColours - 1)],
                    species[RandomNumberGenerator.generate(0, numberOfSpecies - 1)], isCut));
        }
        return flowers;
    }

    public static List<Flower> createListOfArtificialFlowers(int numberOfFlowers) {
        List<Flower> flowers = new ArrayList<>();
        FlowerColour[] colours = FlowerColour.values();
        int numberOfColours = colours.length;
        FlowerSpecies[] species = FlowerSpecies.values();
        int numberOfSpecies = species.length;
        FlowerMaterial[] flowerMaterials = FlowerMaterial.values();
        int numberOfMaterialTypes = flowerMaterials.length;
        for (int i = 0; i < numberOfFlowers; i++) {
            flowers.add(new ArtificialFlower(colours[RandomNumberGenerator.generate(0, numberOfColours - 1)],
                    species[RandomNumberGenerator.generate(0, numberOfSpecies - 1)],
                    flowerMaterials[RandomNumberGenerator.generate(0, numberOfMaterialTypes - 1)]));
        }
        return flowers;
    }

    public static BouquetPackaging createBouquetPackaging() {
        PackColour[] colours = PackColour.values();
        BouquetPackagingType[] types = BouquetPackagingType.values();
        return new BouquetPackaging(colours[RandomNumberGenerator.generate(0, colours.length - 1)],
                types[RandomNumberGenerator.generate(0, types.length - 1)]);
    }

    public static FlowerPot createFlowerPot(int numberOfFlowers) throws IllegalArgumentException {
        PackColour[] colours = PackColour.values();
        FlowerPotMaterial[] types = FlowerPotMaterial.values();
        PackSize[] packSizes = PackSize.values();
        PackSize matchPackSize = null;
        for (PackSize packSize : packSizes) {
            if (packSize.getNumberOfFlowers() >= numberOfFlowers) {
                matchPackSize = packSize;
                break;
            }
        }
        if (Objects.isNull(matchPackSize)) {
            throw new IllegalArgumentException("A match flowerpot size not found! Try reduce the number of flowers.");
        }
        return new FlowerPot(colours[RandomNumberGenerator.generate(0, colours.length - 1)],
                types[RandomNumberGenerator.generate(0, types.length - 1)], matchPackSize);
    }

    public static Container createContainer(int numberOfFlowers) throws IllegalArgumentException {
        PackColour[] colours = PackColour.values();
        ContainerMaterial[] types = ContainerMaterial.values();
        PackSize[] packSizes = PackSize.values();
        PackSize matchPackSize = null;
        for (PackSize packSize : packSizes) {
            if (packSize.getNumberOfFlowers() >= numberOfFlowers) {
                matchPackSize = packSize;
                break;
            }
        }
        if (Objects.isNull(matchPackSize)) {
            throw new IllegalArgumentException("A match container size not found! Try reduce the number of flowers.");
        }
        return new Container(colours[RandomNumberGenerator.generate(0, colours.length - 1)],
                types[RandomNumberGenerator.generate(0, types.length - 1)], matchPackSize,
                RandomNumberGenerator.generate(0, 1) == 1);
    }

    public static BouquetType defineRandomBouquetType() {
        BouquetType[] types = BouquetType.values();
        return types[RandomNumberGenerator.generate(0, types.length - 1)];
    }

    public static SoilType defineRandomSoilType() {
        SoilType[] types = SoilType.values();
        return types[RandomNumberGenerator.generate(0, types.length - 1)];
    }

    public static String defineRandomName() {
        return NAMES_OF_COMPOSITIONS[RandomNumberGenerator.generate(0, NAMES_OF_COMPOSITIONS.length - 1)];
    }

}
