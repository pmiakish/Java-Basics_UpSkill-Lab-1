package com.epam.dragontreasure.entity.treasure.enums;

import java.math.BigDecimal;

public enum CoinType {

    CROWN(BigDecimal.valueOf(1.0)),
    FLOREN(BigDecimal.valueOf(9.5)),
    OREN(BigDecimal.valueOf(1.5));

    private final BigDecimal pricePerStandartUnit;

    CoinType(BigDecimal pricePerStandartUnit) {
        this.pricePerStandartUnit = pricePerStandartUnit;
    }

    public BigDecimal getPricePerStandartUnit() {
        return pricePerStandartUnit;
    }
}
