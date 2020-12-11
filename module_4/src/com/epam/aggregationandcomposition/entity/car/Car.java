package com.epam.aggregationandcomposition.entity.car;

import com.epam.aggregationandcomposition.exceptions.CarLogicalException;
import com.epam.aggregationandcomposition.exceptions.CarTechnicalException;
import java.util.Arrays;
import java.util.Objects;

public class Car {

    private static final float FULL_TANK = 1.0f;
    private static final float FUEL_AMOUNT_TO_ONE_RIDE = 0.2f;
    private static final byte NUMBER_OF_WHEELS = 4;

    String carBrand;
    Engine engine;
    Wheel[] wheels;
    float fuelLevel = 1.0f;

    public Car(String carBrand, Engine engine, Wheel[] wheels) throws CarLogicalException {
        if (carBrand != null && engine != null &&  wheels != null) {
            this.carBrand = carBrand;
            this.engine = engine;
            this.wheels = wheels;
        } else {
            throw new CarLogicalException("Wrong given parameters. Can't create a car!");
        }
    }

    public float go() throws CarTechnicalException {
        if (fuelLevel >= FUEL_AMOUNT_TO_ONE_RIDE) {
            fuelLevel -= FUEL_AMOUNT_TO_ONE_RIDE;
        } else {
            throw new CarTechnicalException("There isn't enough fuel to going. You have to refuel!");
        }
        return fuelLevel;
    }

    public void refuel() {
        try {
            setFuelLevel(FULL_TANK);
        } catch (CarLogicalException e) {
            e.printStackTrace();
        }
    }

    public void changeWheel(byte wheelNumber, String tireBrand, String tireType) throws CarLogicalException{
        if (wheelNumber >= 0 && wheelNumber < NUMBER_OF_WHEELS) {
            if (Wheel.isCorrectTireType(tireType)) {
                byte radius = wheels[wheelNumber].getRadius();
                wheels[wheelNumber] = new Wheel(tireType, tireBrand, radius);
            } else {
                throw new CarLogicalException("Unknown type of the tire. Can't change the wheel!");
            }
        } else {
            throw new CarLogicalException("Wrong wheel number to changing. Can't change the wheel!");
        }
    }

    public void printCarBrand() {
        System.out.println("The car brand is " + carBrand);
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) throws CarLogicalException{
        if (carBrand != null && carBrand.length() != 0) {
            this.carBrand = carBrand;
        } else {
            throw new CarLogicalException("Wrong car name brand. Can't change the current car brand!");
        }
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public float getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(float fuelLevel) throws CarLogicalException {
        if (fuelLevel > 0 && fuelLevel <= FULL_TANK) {
            this.fuelLevel = fuelLevel;
        } else {
            throw new CarLogicalException("Wrong fuel amount. Can't change the current fuel level!");
        }
    }

    @Override
    public String toString() {
        return "Car [" +
                "brand name: " + carBrand +
                "; engine: " + engine +
                "; wheels: " + Arrays.toString(wheels) +
                "; fuel level: " + fuelLevel +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(engine, car.engine) &&
                Arrays.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(engine);
        result = 31 * result + Arrays.hashCode(wheels);
        return result;
    }
}
