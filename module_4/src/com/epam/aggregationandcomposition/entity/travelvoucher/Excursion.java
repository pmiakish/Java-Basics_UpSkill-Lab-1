package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.Objects;

public class Excursion extends Tour {

    private boolean guideEscorting;

    public Excursion(String location, int distance, BigDecimal priceForOneDay, boolean guideEscorting) throws
            TourLogicalException {
        super(location, distance, priceForOneDay);
        this.guideEscorting = guideEscorting;
    }

    public Excursion(String location, int distance, BigDecimal priceForOneDay, boolean guideEscorting, Meal
            includedMeal) throws TourLogicalException {
        super(location, distance, priceForOneDay, includedMeal);
        this.guideEscorting = guideEscorting;
    }

    public boolean getGuideEscorting() {
        return guideEscorting;
    }

    public void setGuideEscorting(int GuideEscorting) {
        this.guideEscorting = guideEscorting;
    }

    @Override
    public String toString() {
        return  "(type: " + getClass().getSimpleName() +
                "; location: " + location +
                "; distance to destination: " + distance + " km" +
                "; price per day (depending on meals): " + pricePerDayDependingOnMeals +
                "; included meals: " + includedMeal +
                "; guide escorting: " + guideEscorting +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excursion other = (Excursion) o;
        return distance == other.distance &&
                Objects.equals(location, other.location) &&
                Objects.equals(pricePerDay, other.pricePerDay) &&
                Objects.equals(pricePerDayDependingOnMeals, other.pricePerDayDependingOnMeals) &&
                includedMeal == other.includedMeal &&
                guideEscorting == other.guideEscorting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, distance, pricePerDay, pricePerDayDependingOnMeals, includedMeal, guideEscorting);
    }
}
