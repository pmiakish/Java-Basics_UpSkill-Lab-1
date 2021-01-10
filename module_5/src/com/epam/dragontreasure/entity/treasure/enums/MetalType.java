package com.epam.dragontreasure.entity.treasure.enums;

import java.math.BigDecimal;

public enum MetalType {

    SILVER(BigDecimal.valueOf(2.5)),
    GOLD(BigDecimal.valueOf(50.0)),
    PLATINUM(BigDecimal.valueOf(32.0));

    private final BigDecimal pricePerStandartUnit;

    MetalType(BigDecimal pricePerStandartUnit) {
        this.pricePerStandartUnit = pricePerStandartUnit;
    }

    public BigDecimal getPricePerStandartUnit() {
        return pricePerStandartUnit;
    }
}
