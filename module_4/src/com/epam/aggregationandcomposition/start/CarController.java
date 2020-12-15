package com.epam.aggregationandcomposition.start;

import com.epam.aggregationandcomposition.entity.car.*;
import com.epam.aggregationandcomposition.exceptions.CarLogicalException;
import com.epam.aggregationandcomposition.exceptions.CarTechnicalException;
import com.epam.aggregationandcomposition.service.RandomNumberGenerator;

public class CarController {

    private static final String[] CAR_BRANDS = {"Volvo", "Audi", "Opel", "BMW", "Honda", "Volkswagen", "Ford",
            "Hyundai", "Nissan", "Mazda", "Peugeot", "Fiat", "Kia"};

    private static final float MIN_ENGINE_DISPLACEMENT = 1.1f;
    private static final float MAX_ENGINE_DISPLACEMENT = 6.0f;

    private static final String[] TIRE_BRANDS = {"Continental", "Goodyear", "Bridgestone", "Pirelli", "Michelin",
            "Yokohama", "Hankook", "Dunlop", "Firestone", "Toyo"};
    private static final byte MIN_WHEEL_RADIUS = 13;
    private static final byte MAX_WHEEL_RADIUS = 20;
    private static final int NUMBER_OF_WHEELS = 4;

    private static final int NUMBER_OF_RIDES = 4;
    private static final byte WHEEL_FOR_CHANGE_NUMBER = 0;

    public static void main(String[] args) {

        try {
            FuelType[] fuelTypes = FuelType.values();
            Engine engine = new Engine(RandomNumberGenerator.generate(MIN_ENGINE_DISPLACEMENT, MAX_ENGINE_DISPLACEMENT),
                    fuelTypes[RandomNumberGenerator.generate(0, fuelTypes.length - 1)]);

            Wheel[] wheels = new Wheel[NUMBER_OF_WHEELS];
            TireType[] tireTypes = TireType.values();
            TireType randomTireType = tireTypes[RandomNumberGenerator.generate(0, tireTypes.length - 1)];
            String tireBrand = TIRE_BRANDS[RandomNumberGenerator.generate(0, TIRE_BRANDS.length - 1)];
            byte radius = RandomNumberGenerator.generate(MIN_WHEEL_RADIUS, MAX_WHEEL_RADIUS);
            for (int i = 0; i < NUMBER_OF_WHEELS; i++) {
                wheels[i] = new Wheel(randomTireType, tireBrand, radius);
            }

            Car car = new Car(CAR_BRANDS[RandomNumberGenerator.generate(0, CAR_BRANDS.length - 1)], engine, wheels);
            System.out.println("The car was create:\n" + car);
            for (int i = 0; i < NUMBER_OF_RIDES; i++) {
                car.go();

            }
            System.out.println("Car refueling");
            car.refuel();
            System.out.println(car);
            System.out.println("A wheel changing");
            car.changeWheel(WHEEL_FOR_CHANGE_NUMBER, TIRE_BRANDS[0], TireType.AS);
            System.out.println(car);
            System.out.println("The car brand is " + car.getCarBrand());

        } catch (CarLogicalException | CarTechnicalException e) {
            e.printStackTrace();
        }

    }

}
