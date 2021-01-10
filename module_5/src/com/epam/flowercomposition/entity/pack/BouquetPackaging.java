package com.epam.flowercomposition.entity.pack;

import com.epam.flowercomposition.entity.pack.enums.BouquetPackagingType;
import com.epam.flowercomposition.entity.pack.enums.PackColour;
import java.util.Objects;

public class BouquetPackaging extends Pack {

    public BouquetPackaging(PackColour packColour, BouquetPackagingType bouquetPackagingType) throws
            NullPointerException {
        super(packColour, bouquetPackagingType);
    }

    @Override
    public String toString() {
        return "Bouquet packaging [" +
                "colour: " + packColour +
                ", pack type: " + packType +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

}
