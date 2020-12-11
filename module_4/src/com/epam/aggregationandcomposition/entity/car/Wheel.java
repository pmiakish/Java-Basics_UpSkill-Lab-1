package com.epam.aggregationandcomposition.entity.car;

import com.epam.aggregationandcomposition.exceptions.CarLogicalException;
import java.util.Arrays;
import java.util.Objects;

public class Wheel {

    private static final String[] CORRECT_TIRE_TYPES = {"AS", "M+S", "Winter", "Summer", "Rain"};
    private static final byte MIN_WHEEL_RADIUS = 13;
    private static final byte MAX_WHEEL_RADIUS = 20;

    String tireType;
    String tireBrand;
    byte radius;

    public Wheel(String tireType, String tireBrand, byte radius) throws CarLogicalException {
        if (isCorrectTireType(tireType) && radius >= MIN_WHEEL_RADIUS && radius <= MAX_WHEEL_RADIUS) {
            this.tireType = tireType;
            this.tireBrand = tireBrand;
            this.radius = radius;
        } else {
            throw new CarLogicalException("Wrong given parameters of a wheel. Can't create a wheel!");
        }
    }

    public static boolean isCorrectTireType(String tireType) {
        return tireType != null && Arrays.stream(CORRECT_TIRE_TYPES).anyMatch(tireType::equalsIgnoreCase);
    }

    public String getTireType() {
        return tireType;
    }

    public void setTireType(String tireType) throws CarLogicalException {
        if (isCorrectTireType(tireType)) {
            this.tireType = tireType;
        } else {
            throw new CarLogicalException("Unknown type of the tire. Can't change the current tire type!");
        }
    }

    public byte getRadius() {
        return radius;
    }

    public void setRadius(byte radius) throws CarLogicalException {
        if (radius >= MIN_WHEEL_RADIUS && radius <= MAX_WHEEL_RADIUS && radius != this.radius) {
            this.radius = radius;
        } else {
            throw new CarLogicalException("Wrong value of a wheel radius. Can't change the current wheel radius!");
        }
    }

    @Override
    public String toString() {
        return "(" +
                "tireType='" + tireType + '\'' +
                ", tireBrand='" + tireBrand + '\'' +
                ", radius=" + radius +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius &&
                Objects.equals(tireType, wheel.tireType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tireType, radius);
    }
}
