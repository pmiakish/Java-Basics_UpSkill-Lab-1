package com.epam.aggregationandcomposition.start;

import com.epam.aggregationandcomposition.entity.car.Car;
import com.epam.aggregationandcomposition.entity.car.Engine;
import com.epam.aggregationandcomposition.entity.car.Wheel;
import com.epam.aggregationandcomposition.exceptions.CarLogicalException;
import com.epam.aggregationandcomposition.exceptions.CarTechnicalException;
import com.epam.aggregationandcomposition.service.RandomNumberGenerator;

public class CarController {

    private static final String[] CAR_BRANDS = {"Volvo", "Audi", "Opel", "BMW", "Honda", "Volkswagen", "Ford",
            "Hyundai", "Nissan", "Mazda", "Peugeot", "Fiat", "Kia"};

    private static final float MIN_ENGINE_DISPLACEMENT = 1.1f;
    private static final float MAX_ENGINE_DISPLACEMENT = 6.0f;
    private static final String[] FUEL_TYPES = {"Diesel", "Petrol"};

    private static final String[] TIRE_TYPES = {"AS", "M+S", "Winter", "Summer", "Rain"};
    private static final String[] TIRE_BRANDS = {"Continental", "Goodyear", "Bridgestone", "Pirelli", "Michelin",
            "Yokohama", "Hankook", "Dunlop", "Firestone", "Toyo"};
    private static final byte MIN_WHEEL_RADIUS = 13;
    private static final byte MAX_WHEEL_RADIUS = 20;
    private static final int NUMBER_OF_WHEELS = 4;

    private static final int NUMBER_OF_RIDES = 4;
    private static final byte WHEEL_FOR_CHANGE_NUMBER = 0;

    public static void main(String[] args) {

        // --- TASK 02 ---
        try {
            Engine engine = new Engine(RandomNumberGenerator.generate(MIN_ENGINE_DISPLACEMENT, MAX_ENGINE_DISPLACEMENT),
                    FUEL_TYPES[RandomNumberGenerator.generate(0, FUEL_TYPES.length - 1)]);

            Wheel[] wheels = new Wheel[NUMBER_OF_WHEELS];
            String tireType = TIRE_TYPES[RandomNumberGenerator.generate(0, TIRE_TYPES.length - 1)];
            String tireBrand = TIRE_BRANDS[RandomNumberGenerator.generate(0, TIRE_BRANDS.length - 1)];
            byte radius = RandomNumberGenerator.generate(MIN_WHEEL_RADIUS, MAX_WHEEL_RADIUS);
            for (int i = 0; i < NUMBER_OF_WHEELS; i++) {
                wheels[i] = new Wheel(tireType, tireBrand, radius);
            }

            Car car = new Car(CAR_BRANDS[RandomNumberGenerator.generate(0, CAR_BRANDS.length - 1)], engine, wheels);
            System.out.println("The car was create:\n" + car);
            for (int i = 0; i < NUMBER_OF_RIDES; i++) {
                car.go();
                System.out.println("The car is going... The fuel level is " + car.getFuelLevel());
            }
            System.out.println("Car refueling");
            car.refuel();
            System.out.println(car);
            System.out.println("A wheel changing");
            car.changeWheel(WHEEL_FOR_CHANGE_NUMBER, TIRE_BRANDS[0], TIRE_TYPES[0]);
            System.out.println(car);
            car.printCarBrand();

        } catch (CarLogicalException | CarTechnicalException e) {
            e.printStackTrace();
        }

    }

}
