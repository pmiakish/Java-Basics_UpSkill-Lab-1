package com.epam.aggregationandcomposition.entity.travelvoucher;

public enum Meal {

    NONE(1.0),
    BREAKFAST(1.2),
    BREAKFAST_LUNCH(1.4),
    BREAKFAST_DINNER(1.5),
    ALL_INCLUSIVE(1.8),
    ULTRA_ALL_INCLUSIVE(2.0);

    private double priceCorrectionCoefficient;

    Meal(double priceCorrectionCoefficient) {
        this.priceCorrectionCoefficient = priceCorrectionCoefficient;
    }

    public double getPriceCorrectionCoefficient() {
        return priceCorrectionCoefficient;
    }
}
