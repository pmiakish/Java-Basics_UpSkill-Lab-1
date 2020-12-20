package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.Objects;

public class Cruise extends Tour {

    private int lengthOfRoute;

    public Cruise(String location, int distance, BigDecimal priceForOneDay, int lengthOfRoute) throws
            TourLogicalException {
        super(location, distance, priceForOneDay);
        if (lengthOfRoute > 0) {
            this.lengthOfRoute = lengthOfRoute;
        } else {
            throw new TourLogicalException("Incorrect length of the route!");
        }
    }

    public Cruise(String location, int distance, BigDecimal priceForOneDay, int lengthOfRoute, Meal includedMeal) throws
            TourLogicalException {
        super(location, distance, priceForOneDay, includedMeal);
        if (lengthOfRoute > 0) {
            this.lengthOfRoute = lengthOfRoute;
        } else {
            throw new TourLogicalException("Incorrect length of the route!");
        }
    }

    public int getLengthOfRoute() {
        return lengthOfRoute;
    }

    public void setLengthOfRoute(int lengthOfRoute) throws TourLogicalException{
        if (lengthOfRoute > 0) {
            this.lengthOfRoute = lengthOfRoute;
        } else {
            throw new TourLogicalException("Incorrect parameter! Can't change length of the route!");
        }
    }

    @Override
    public String toString() {
        return  "(type: " + getClass().getSimpleName() +
                "; location: " + location +
                "; distance to destination: " + distance + " km" +
                "; price per day (depending on meals): " + pricePerDayDependingOnMeals +
                "; included meals: " + includedMeal +
                "; length of the route: " + lengthOfRoute +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruise other = (Cruise) o;
        return distance == other.distance &&
                Objects.equals(location, other.location) &&
                Objects.equals(pricePerDay, other.pricePerDay) &&
                Objects.equals(pricePerDayDependingOnMeals, other.pricePerDayDependingOnMeals) &&
                includedMeal == other.includedMeal &&
                lengthOfRoute == other.lengthOfRoute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, distance, pricePerDay, pricePerDayDependingOnMeals, includedMeal, lengthOfRoute);
    }

}
