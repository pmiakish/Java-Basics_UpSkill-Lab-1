package com.epam.dragontreasure.util.init;

import com.epam.dragontreasure.entity.Cave;
import com.epam.dragontreasure.entity.treasure.Coin;
import com.epam.dragontreasure.entity.treasure.Gemstone;
import com.epam.dragontreasure.entity.treasure.Ingot;
import com.epam.dragontreasure.entity.treasure.Jewellery;
import com.epam.dragontreasure.entity.treasure.enums.CoinType;
import com.epam.dragontreasure.entity.treasure.enums.GemstoneType;
import com.epam.dragontreasure.entity.treasure.enums.JewelleryType;
import com.epam.dragontreasure.entity.treasure.enums.MetalType;
import java.time.Year;
import java.util.Objects;

public class TreasureInitializer {

    private static final int MAX_NUMBER_OF_COINS = 1000;
    private static final int MIN_YEAR_OF_COIN_ISSUE = 1200;
    private static final int MAX_YEAR_OF_COIN_ISSUE = 2000;
    private static final int MIN_GEMSTONE_WEIGHT = 2;
    private static final int MAX_GEMSTONE_WEIGHT = 25;
    private static final int MAX_GEMSTONE_WEIGHT_JEWELLERY = 7;
    private static final int MIN_INGOT_WEIGHT = 200;
    private static final int MAX_INGOT_WEIGHT = 1000;
    private static final int MIN_JEWELLERY_WEIGHT = 3;
    private static final int MAX_NUMBER_OF_GEMSTONES = 5;
    private static final int NUMBER_OF_GEMSTONES_JEWELLERY = 1;
    private static final int MAX_NUMBER_OF_INGOTS = 10;
    private static final int MAX_NUMBER_OF_JEWELLERY = 3;

    public static void fillCave(Cave cave, int numberOfEachTypeTreasures) throws NullPointerException,
            IllegalArgumentException {

        Objects.requireNonNull(cave, "The cave can't be null!");

        if (numberOfEachTypeTreasures > 0) {

            try {
                Cave.Dragon dragon = cave.callDragon();
                dragon.removeAllTreasures();

                // Coins
                for (int i = 0; i < numberOfEachTypeTreasures; i++) {
                    dragon.addTreasure(createCoinTreasure());
                }

                // Gemstones
                for (int i = 0; i < numberOfEachTypeTreasures; i++) {
                    dragon.addTreasure(createGemstoneTreasure(false));
                }

                // Ingots
                for (int i = 0; i < numberOfEachTypeTreasures; i++) {
                    dragon.addTreasure(createIngotTreasure());
                }

                // Jewellery
                for (int i = 0; i < numberOfEachTypeTreasures; i++) {
                    dragon.addTreasure(createJewelleryTreasure());
                }

            } catch (NullPointerException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Incorrect number of the treasures!");
        }
    }

    private static Coin createCoinTreasure() throws NullPointerException, IllegalArgumentException {
        CoinType[] coinTypes = CoinType.values();
        return new Coin(coinTypes[RandomNumberGenerator.generate(0, coinTypes.length - 1)],
                RandomNumberGenerator.generate(1, MAX_NUMBER_OF_COINS),
                Year.of(RandomNumberGenerator.generate(MIN_YEAR_OF_COIN_ISSUE, MAX_YEAR_OF_COIN_ISSUE)));
    }

    private static Gemstone createGemstoneTreasure(boolean isForJewellery) throws NullPointerException,
            IllegalArgumentException {
        GemstoneType[] gemstoneTypes = GemstoneType.values();
        return new Gemstone(gemstoneTypes[RandomNumberGenerator.generate(0, gemstoneTypes.length - 1)],
                (isForJewellery) ? NUMBER_OF_GEMSTONES_JEWELLERY : RandomNumberGenerator.generate(1,
                        MAX_NUMBER_OF_GEMSTONES),
                RandomNumberGenerator.generate(MIN_GEMSTONE_WEIGHT, (isForJewellery) ? MAX_GEMSTONE_WEIGHT_JEWELLERY :
                        MAX_GEMSTONE_WEIGHT),
                isForJewellery || (RandomNumberGenerator.generate(0, 1) == 1));
    }

    private static Ingot createIngotTreasure() throws NullPointerException, IllegalArgumentException {
        MetalType[] ingotTypes = MetalType.values();
        return new Ingot(ingotTypes[RandomNumberGenerator.generate(0, ingotTypes.length - 1)],
                RandomNumberGenerator.generate(1, MAX_NUMBER_OF_INGOTS),
                RandomNumberGenerator.generate(MIN_INGOT_WEIGHT, MAX_INGOT_WEIGHT));
    }

    private static Jewellery createJewelleryTreasure() throws NullPointerException, IllegalArgumentException {
        JewelleryType[] jewelleryTypes = JewelleryType.values();
        JewelleryType jewelleryType = jewelleryTypes[RandomNumberGenerator.generate(0, jewelleryTypes.length - 1)];
        MetalType[] metalTypes = MetalType.values();
        return new Jewellery(jewelleryType,
                RandomNumberGenerator.generate(1, MAX_NUMBER_OF_JEWELLERY),
                metalTypes[RandomNumberGenerator.generate(0, metalTypes.length - 1)],
                RandomNumberGenerator.generate(MIN_JEWELLERY_WEIGHT, jewelleryType.getMaxWeight()),
                createGemstoneTreasure(true));
    }


}
