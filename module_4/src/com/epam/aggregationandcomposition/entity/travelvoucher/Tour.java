package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public abstract class Tour {

    private static final String NAME_OF_LOCATION_PATTERN = "^[A-Z]+[A-Za-z0-9 -]+$";

    protected String location;
    protected int distance;
    protected BigDecimal pricePerDay;
    protected BigDecimal pricePerDayDependingOnMeals;
    protected Meal includedMeal = Meal.NONE;

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
                Pattern.compile(NAME_OF_LOCATION_PATTERN).matcher(location).matches());
    }

    private boolean isCorrectPrice(BigDecimal priceForOneDay) {
        return (priceForOneDay != null &&
                priceForOneDay.compareTo(BigDecimal.ZERO) > 0);
    }

    private void adjustPriceDependingOnMeals() {
        switch (this.includedMeal) {
            case BREAKFAST:
                this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                        valueOf(Meal.BREAKFAST.getPriceCorrectionCoefficient()));
                break;
            case BREAKFAST_LUNCH:
                this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                        valueOf(Meal.BREAKFAST_LUNCH.getPriceCorrectionCoefficient()));
                break;
            case BREAKFAST_DINNER:
                this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                        valueOf(Meal.BREAKFAST_DINNER.getPriceCorrectionCoefficient()));
                break;
            case ALL_INCLUSIVE:
                this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                        valueOf(Meal.ALL_INCLUSIVE.getPriceCorrectionCoefficient()));
                break;
            case ULTRA_ALL_INCLUSIVE:
                this.pricePerDayDependingOnMeals = this.pricePerDay.multiply(BigDecimal.
                        valueOf(Meal.ULTRA_ALL_INCLUSIVE.getPriceCorrectionCoefficient()));
                break;
            default:
                break;
        }
    }

}
