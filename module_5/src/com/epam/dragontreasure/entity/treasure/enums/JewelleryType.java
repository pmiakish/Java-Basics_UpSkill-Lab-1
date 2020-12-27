package com.epam.dragontreasure.entity.treasure.enums;

public enum JewelleryType {

    RING(4),
    NECKLACE(35),
    BRACELET(25),
    PENDANT(15);

    private final int maxWeight;

    JewelleryType(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
