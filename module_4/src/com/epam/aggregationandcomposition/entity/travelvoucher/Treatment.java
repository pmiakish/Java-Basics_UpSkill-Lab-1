package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.Objects;

public class Treatment extends Tour {

    private int numberOfMedicalProcedures;

    public Treatment(String location, int distance, BigDecimal priceForOneDay, int numberOfMedicalProcedures) throws
            TourLogicalException {
        super(location, distance, priceForOneDay);
        if (numberOfMedicalProcedures > 0) {
            this.numberOfMedicalProcedures = numberOfMedicalProcedures;
        } else {
            throw new TourLogicalException("Incorrect number of medical procedures!");
        }
    }

    public Treatment(String location, int distance, BigDecimal priceForOneDay, int numberOfMedicalProcedures,
                     Meal includedMeal) throws TourLogicalException {
        super(location, distance, priceForOneDay, includedMeal);
        if (numberOfMedicalProcedures > 0) {
            this.numberOfMedicalProcedures = numberOfMedicalProcedures;
        } else {
            throw new TourLogicalException("Incorrect number of medical procedures!");
        }
    }

    public int getNumberOfMedicalProcedures() {
        return numberOfMedicalProcedures;
    }

    public void setNumberOfMedicalProcedures(int numberOfMedicalProcedures) throws TourLogicalException{
        if (numberOfMedicalProcedures > 0) {
            this.numberOfMedicalProcedures = numberOfMedicalProcedures;
        } else {
            throw new TourLogicalException("Incorrect parameter! Can't change the number of medical procedures!");
        }
    }

    @Override
    public String toString() {
        return  "(type: " + getClass().getSimpleName() +
                "; location: " + location +
                "; distance to destination: " + distance + " km" +
                "; price per day (depending on meals): " + pricePerDayDependingOnMeals +
                "; included meals: " + includedMeal +
                "; number of medical procedures: " + numberOfMedicalProcedures +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treatment other = (Treatment) o;
        return distance == other.distance &&
                Objects.equals(location, other.location) &&
                Objects.equals(pricePerDay, other.pricePerDay) &&
                Objects.equals(pricePerDayDependingOnMeals, other.pricePerDayDependingOnMeals) &&
                includedMeal == other.includedMeal &&
                numberOfMedicalProcedures == other.numberOfMedicalProcedures;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, distance, pricePerDay, pricePerDayDependingOnMeals, includedMeal,
                numberOfMedicalProcedures);
    }
}
