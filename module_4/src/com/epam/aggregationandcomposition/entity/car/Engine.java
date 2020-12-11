package com.epam.aggregationandcomposition.entity.car;

import com.epam.aggregationandcomposition.exceptions.CarLogicalException;
import java.util.Arrays;
import java.util.Objects;

public class Engine {

    private static final float MIN_ENGINE_DISPLACEMENT = 1.1f;
    private static final float MAX_ENGINE_DISPLACEMENT = 6.0f;
    private static final String[] CORRECT_FUEL_TYPES = {"Diesel", "Petrol"};

    float displacement;
    String fuelType;

    public Engine(float displacement, String fuelType) throws CarLogicalException {
        if (isCorrectFuelType(fuelType) && displacement >= MIN_ENGINE_DISPLACEMENT && displacement <=
                MAX_ENGINE_DISPLACEMENT) {
            this.displacement = displacement;
            this.fuelType = fuelType;
        } else {
            throw new CarLogicalException("Wrong given parameters of a wheel. Can't create a wheel!");
        }
    }

    public static boolean isCorrectFuelType(String fuelType) {
        return fuelType != null && Arrays.stream(CORRECT_FUEL_TYPES).anyMatch(fuelType::equalsIgnoreCase);
    }

    public float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(float displacement) throws CarLogicalException {
        if (displacement >= MIN_ENGINE_DISPLACEMENT && displacement <= MAX_ENGINE_DISPLACEMENT) {
            this.displacement = displacement;
        } else {
            throw new CarLogicalException("Wrong value of engine displacement. Can't change the current value of " +
                    "engine displacement!");
        }
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) throws CarLogicalException {
        if (isCorrectFuelType(fuelType)) {
            this.fuelType = fuelType;
        } else {
            throw new CarLogicalException("Unknown type of fuel. Can't change the current fuel type!");
        }
    }

    @Override
    public String toString() {
        return "(" +
                "displacement=" + displacement +
                ", fuelType='" + fuelType + '\'' +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Float.compare(engine.displacement, displacement) == 0 &&
                Objects.equals(fuelType, engine.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displacement, fuelType);
    }
}
