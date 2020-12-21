package com.epam.aggregationandcomposition.entity.car;

import com.epam.aggregationandcomposition.exceptions.CarLogicalException;
import java.util.Objects;

public class Engine {

    private static final float MIN_ENGINE_DISPLACEMENT = 1.1f;
    private static final float MAX_ENGINE_DISPLACEMENT = 6.0f;

    private float displacement;
    private FuelType fuelType;

    public Engine(float displacement, FuelType fuelType) throws CarLogicalException {
        if (fuelType != null && displacement >= MIN_ENGINE_DISPLACEMENT && displacement <= MAX_ENGINE_DISPLACEMENT) {
            this.displacement = displacement;
            this.fuelType = fuelType;
        } else {
            throw new CarLogicalException("Wrong given parameters of a wheel. Can't create a wheel!");
        }
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

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) throws CarLogicalException {
        if (fuelType != null) {
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
