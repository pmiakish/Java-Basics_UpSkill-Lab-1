package com.epam.dragontreasure.entity;

import com.epam.dragontreasure.entity.treasure.Treasure;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Cave {

    private final List<Treasure> treasures;
    private final Dragon dragon = new Dragon();

    public Cave() {
        this.treasures = new ArrayList<>();
    }

    public class Dragon {

        private Dragon() {}

        private String dragonName = "Drogon";

        public String getDragonName() {
            return dragonName;
        }

        public void setDragonName(String dragonName) throws NullPointerException {
            this.dragonName = Objects.requireNonNull(dragonName, "The dragon name can't be null!");
        }

        public int countTreasures() {
            return treasures.size();
        }

        public String showTreasures() {
            return treasures.stream().map(Treasure::toString).reduce("", String::concat);
        }

        public void addTreasure(Treasure treasure) throws NullPointerException {
            treasures.add(Objects.requireNonNull(treasure, "The treasure can't be null!"));
        }

        public void removeTreasure(int index) throws IllegalArgumentException {
            if (treasures.size() > 0 && index >= 0 && index < treasures.size() - 1) {
                treasures.remove(index);
            } else {
                throw new IllegalArgumentException("Can't remove a treasure because item with the specified index " +
                        "does not exist!");
            }
        }

        public void removeLastTreasure() {
            if (treasures.size() > 0) {
                treasures.remove(treasures.size() - 1);
            }
        }

        public void removeAllTreasures() {
            if (treasures.size() > 0) {
                treasures.clear();
            }
        }

        public Treasure getMostExpensiveTreasure() {
            return Collections.max(treasures);
        }

        public List<Treasure> selectTreasuresByPrice(BigDecimal minPrice, BigDecimal maxPrice) throws
                NullPointerException, IllegalArgumentException {
            Objects.requireNonNull(minPrice, "The min price can't be null!");
            Objects.requireNonNull(maxPrice, "The max price can't be null!");
            if (minPrice.compareTo(BigDecimal.ZERO) > 0 && maxPrice.compareTo(minPrice) >= 0) {
                return treasures.stream().filter(treasure -> (treasure.calculatePrice().compareTo(minPrice) >= 0 &&
                        treasure.calculatePrice().compareTo(maxPrice) <= 0)).sorted().collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Incorrect value of the price!");
            }
        }

        @Override
        public String toString() {
            return "Dragon [" +
                    "dragon name: " + dragonName +
                    "]";
        }

    }

    public Dragon callDragon() {
        return dragon;
    }
}
