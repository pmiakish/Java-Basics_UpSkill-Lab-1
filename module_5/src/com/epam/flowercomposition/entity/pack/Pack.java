package com.epam.flowercomposition.entity.pack;

import com.epam.flowercomposition.entity.pack.enums.PackColour;
import java.util.Objects;

public abstract class Pack {

    protected PackColour packColour;
    protected Enum packType;

    protected Pack(PackColour packColour, Enum packType) throws NullPointerException {
        this.packColour = Objects.requireNonNull(packColour, "The colour of the flower cannot be null!");
        this.packType = Objects.requireNonNull(packType, "The pack type cannot be null!");
    }

    public PackColour getColour() {
        return packColour;
    }

    public void setColour(PackColour packColour) throws NullPointerException {
        this.packColour = Objects.requireNonNull(packColour, "The colour of the flower cannot be null!");
    }

    public Enum getPackType() {
        return packType;
    }

    public void setPackType(Enum packType) throws NullPointerException {
        this.packType = Objects.requireNonNull(packType, "The pack type cannot be null!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack other = (Pack) o;
        return packColour == other.packColour &&
                Objects.equals(packType, other.packType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packColour, packType);
    }
}
