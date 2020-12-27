package com.epam.dragontreasure.entity.treasure.enums;

import java.math.BigDecimal;

public enum GemstoneType {

    AMETHYST(BigDecimal.valueOf(50.0)),
    DIAMOND(BigDecimal.valueOf(15000.0)),
    EMERALD(BigDecimal.valueOf(8000.0)),
    OPAL(BigDecimal.valueOf(250.0)),
    RUBY(BigDecimal.valueOf(13500.0)),
    SAPPHIRE(BigDecimal.valueOf(5500.0)),
    TOPAZ(BigDecimal.valueOf(100.0));

    private final BigDecimal pricePerStandartUnit;

    GemstoneType(BigDecimal pricePerStandartUnit) {
        this.pricePerStandartUnit = pricePerStandartUnit;
    }

    public BigDecimal getPricePerStandartUnit() {
        return pricePerStandartUnit;
    }
}
