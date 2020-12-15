package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Tour {

    private static final double[] PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_MEALS = {
            1.2, // BREAKFAST
            1.4, // BREAKFAST_LUNCH
            1.5, // BREAKFAST_DINNER
            1.8, // ALL_INCLUSIVE
            2.0  // ULTRA_ALL_INCLUSIVE
    };

    private String location;
    private int distance;
    private BigDecimal pricePerDay;
    private BigDecimal pricePerDayDependingOnMeals;
    private Meal includedMeal = Meal.NONE;

    public Tour(String location, int distance, BigDecimal pricePerDay) throws TourLogicalException {
        if (isCorrectNameOfLocation(location) && isCorrectPrice(pricePerDay) && distance > 0) {
            this.location = location;
            this.distance = distance;
            this.pricePerDay = this.pricePerDayDependingOnMeals = pricePerDay;
        } else {
            throw new TourLogicalException("Incorrect parameters. Can't create a tour!");
        }
    }

    public Tour(String location, int distance, BigDecimal pricePerDay, Meal includedMeal) throws
            TourLogicalException {
        this(location, distance, pricePerDay);
        if (includedMeal != null) {
            this.includedMeal = includedMeal;
            adjustPriceDependingOnMeals();
        } else {
            throw new TourLogicalException("Incorrect parameters. Can't create a tour!");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws TourLogicalException {
        if (isCorrectNameOfLocation(location)) {
            this.location = location;
        } else {
            throw new TourLogicalException("Incorrect parameter. Can't change the tour location!");
        }
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) throws TourLogicalException {
        if (distance > 0) {
            this.distance = distance;
        } else {
            throw new TourLogicalException("Incorrect parameter. Can't change the distance to destination!");
        }
    }

    public BigDecimal getPricePerDayDependingOnMeals() {
        return pricePerDayDependingOnMeals;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) throws TourLogicalException {
        if (isCorrectPrice(pricePerDay)) {
            this.pricePerDay = pricePerDay;
            adjustPriceDependingOnMeals();
        } else {
            throw new TourLogicalException("Incorrect parameter. Can't change the tour price!");
        }
    }

    public Meal getIncludedMeals() {
        return includedMeal;
    }

    public void setIncludedMeals(Meal includedMeal) throws TourLogicalException {
        if (includedMeal != null) {
            this.includedMeal = includedMeal;
            adjustPriceDependingOnMeals();
        } else {
            throw new TourLogicalException("Incorrect parameter. Can't change the tour price!");
        }
    }

    private boolean isCorrectNameOfLocation(String location) {
        return (location != null &&
                location.length() != 0 &&
                Pattern.compile("^[A-Z]+[A-Za-z0-9 -]+$").matcher(location).matches());
    }

    private boolean isCorrectPrice(BigDecimal priceForOneDay) {
        return (priceForOneDay != null &&
                priceForOneDay.compareTo(BigDecimal.ZERO) > 0);
    }

    private void adjustPriceDependingOnMeals() {
        if (this.includedMeal != null) {
            switch (this.includedMeal) {
                case BREAKFAST:
                    this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                            valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_MEALS[0]));
                    break;
                case BREAKFAST_LUNCH:
                    this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                            valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_MEALS[1]));
                    break;
                case BREAKFAST_DINNER:
                    this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                            valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_MEALS[2]));
                    break;
                case ALL_INCLUSIVE:
                    this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                            valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_MEALS[3]));
                    break;
                case ULTRA_ALL_INCLUSIVE:
                    this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                            valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_MEALS[4]));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return  "(type: " + getClass().getSimpleName() +
                "; location: " + location +
                "; distance to destination: " + distance + " km" +
                "; price per day (depending on meals): " + pricePerDayDependingOnMeals +
                "; included meals: " + includedMeal +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour other = (Tour) o;
        return distance == other.distance &&
                Objects.equals(location, other.location) &&
                Objects.equals(pricePerDay, other.pricePerDay) &&
                Objects.equals(pricePerDayDependingOnMeals, other.pricePerDayDependingOnMeals) &&
                includedMeal == other.includedMeal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, distance, pricePerDay, pricePerDayDependingOnMeals, includedMeal);
    }
}
