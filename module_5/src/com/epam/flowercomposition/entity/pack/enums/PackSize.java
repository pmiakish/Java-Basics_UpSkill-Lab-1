package com.epam.flowercomposition.entity.pack.enums;

public enum PackSize {
    SMALL(5),
    MEDIUM(10),
    LARGE(20),
    EXTRA_LARGE(50);

    private final int numberOfFlowers;

    PackSize(int numberOfFlowers) {
        this.numberOfFlowers = numberOfFlowers;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }
}
