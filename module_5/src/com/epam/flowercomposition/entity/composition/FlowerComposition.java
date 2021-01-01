package com.epam.flowercomposition.entity.composition;

import com.epam.flowercomposition.entity.flower.Flower;
import com.epam.flowercomposition.entity.pack.Pack;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public abstract class FlowerComposition {

    private static final String NAME_PATTERN = "^\\w[\\w '-]*\\w$";

    protected List<Flower> flowers;
    protected Pack pack;
    protected String name;

    protected FlowerComposition(List<Flower> flowers, Pack pack, String name) throws NullPointerException,
            IllegalArgumentException {
        if (Pattern.compile(NAME_PATTERN).matcher(name).matches() && flowers.size() != 0 && name.length() != 0) {
            this.flowers = Objects.requireNonNull(flowers, "The list of flowers cannot be null!");
            this.pack = Objects.requireNonNull(pack, "The pack cannot be null!");
            this.name = Objects.requireNonNull(name, "The name of the flower composition cannot be null!");
        } else {
            throw new IllegalArgumentException("Incorrect parameters! Cannot create a flower composition.");
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) throws NullPointerException, IllegalArgumentException {
        if (flowers.size() != 0) {
            this.flowers = Objects.requireNonNull(flowers, "The list of flowers cannot be null!");
        } else {
            throw new IllegalArgumentException("Incorrect parameter! Cannot change the list of flowers.");
        }
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) throws NullPointerException {
        this.pack = Objects.requireNonNull(pack, "The pack cannot be null!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException, IllegalArgumentException {
        if (Pattern.compile(NAME_PATTERN).matcher(name).matches() && name.length() != 0) {
            this.name = Objects.requireNonNull(name, "The name of the flower composition cannot be null!");
        } else {
            throw new IllegalArgumentException("Incorrect parameter! Cannot change the name of the flower " +
                    "composition.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerComposition other = (FlowerComposition) o;
        return Objects.equals(flowers, other.flowers) &&
                Objects.equals(pack, other.pack) &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowers, pack, name);
    }
}
