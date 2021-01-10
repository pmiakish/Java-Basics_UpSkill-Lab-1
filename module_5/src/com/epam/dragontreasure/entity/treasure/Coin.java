package com.epam.dragontreasure.entity.treasure;

import com.epam.dragontreasure.entity.treasure.enums.CoinType;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Objects;

public class Coin extends Treasure {

    private static final Year YEAR_OF_ISSUE_1 = Year.of(1500);
    private static final double CORRECTION_RATIO_1 = 3.0;
    private static final Year YEAR_OF_ISSUE_2 = Year.of(1700);
    private static final double CORRECTION_RATIO_2 = 2.0;
    private static final Year YEAR_OF_ISSUE_3 = Year.of(1900);
    private static final double CORRECTION_RATIO_3 = 1.5;
    private static final double DEFAULT_CORRECTION_RATIO = 1.5;

    private Year yearOfIssue;

    public Coin(CoinType type, int numberOfItems, Year yearOfIssue) throws NullPointerException,
            IllegalArgumentException {
        super(type, numberOfItems);
        this.yearOfIssue = Objects.requireNonNull(yearOfIssue, "A year of the coin issue can't be null!");
    }

    public Year getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Year yearOfIssue) throws NullPointerException {
        this.yearOfIssue = Objects.requireNonNull(yearOfIssue, "A year of the coin issue can't be null!");
    }

    @Override
    public BigDecimal calculatePrice() {
        double correctionRatio = (yearOfIssue.isBefore(YEAR_OF_ISSUE_1)) ? CORRECTION_RATIO_1 :
                (yearOfIssue.isBefore(YEAR_OF_ISSUE_2)) ? CORRECTION_RATIO_2 :
                (yearOfIssue.isBefore(YEAR_OF_ISSUE_3)) ? CORRECTION_RATIO_3 :
                DEFAULT_CORRECTION_RATIO;
        return ((CoinType)type).getPricePerStandartUnit().multiply(BigDecimal.valueOf(numberOfItems).multiply(BigDecimal.
                valueOf(correctionRatio)));
    }

    @Override
    public String toString() {
        return "Coin {" +
                "type: " + type +
                "; year of issue: " + yearOfIssue +
                "; number of items: " + numberOfItems +
                "; price: " + calculatePrice() +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin other = (Coin) o;
        return yearOfIssue == other.yearOfIssue &&
                type == other.type &&
                numberOfItems == other.numberOfItems;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfIssue, type, numberOfItems);
    }

}
