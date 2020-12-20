package com.epam.payment.entity;

import com.epam.payment.exceptions.PurchaseLogicalException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {

    private List<Purchase> purchases = new ArrayList<>();

    public void addPurchase(String name, BigDecimal pricePerPiece, int numberOfPieces) throws PurchaseLogicalException {
        this.purchases.add(new Purchase(name, pricePerPiece, numberOfPieces));
    }

    public BigDecimal getTotalAmount() {
        return purchases.stream().map(Purchase::calculatePrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private class Purchase {
        private String name;
        private BigDecimal pricePerPiece;
        private int numberOfPieces;

        public Purchase(String name, BigDecimal pricePerPiece, int numberOfPieces) throws PurchaseLogicalException {
            if (name != null && name.length() != 0 &&
                    pricePerPiece != null && pricePerPiece.compareTo(BigDecimal.ZERO) > 0 &&
                    numberOfPieces > 0) {
                this.name = name;
                this.pricePerPiece = pricePerPiece;
                this.numberOfPieces = numberOfPieces;
            } else {
                throw new PurchaseLogicalException("Incorrect parameters. Can't create a purchase!");
            }
        }

        public BigDecimal calculatePrice() {
            return pricePerPiece.multiply(BigDecimal.valueOf(numberOfPieces));
        }

        public String getName() {
            return name;
        }

        public void setName(String name) throws PurchaseLogicalException {
            if (name != null && name.length() != 0) {
                this.name = name;
            } else {
                throw new PurchaseLogicalException("Incorrect parameter. Can't change the purchase name!");
            }
        }

        public BigDecimal getPricePerPiece() {
            return pricePerPiece;
        }

        public void setPricePerPiece(BigDecimal pricePerPiece) throws PurchaseLogicalException {
            if (pricePerPiece != null && pricePerPiece.compareTo(BigDecimal.ZERO) > 0) {
                this.pricePerPiece = pricePerPiece;
            } else {
                throw new PurchaseLogicalException("Incorrect parameter. Can't change the purchase price per piece!");
            }
        }

        public int getNumberOfPieces() {
            return numberOfPieces;
        }

        public void setNumberOfPieces(int numberOfPieces) throws PurchaseLogicalException {
            if (numberOfPieces > 0) {
                this.numberOfPieces = numberOfPieces;
            } else {
                throw new PurchaseLogicalException("Incorrect parameter. Can't change the purchase number of pieces!");
            }
        }

        @Override
        public String toString() {
            return "Purchase [" + name +
                    "; price per piece: " + pricePerPiece +
                    "; number of pieces: " + numberOfPieces +
                    "; price: " + calculatePrice() +
                    "]\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Purchase other = (Purchase) o;
            return numberOfPieces == other.numberOfPieces &&
                    Objects.equals(name, other.name) &&
                    Objects.equals(pricePerPiece, other.pricePerPiece);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, pricePerPiece, numberOfPieces);
        }
    }

    @Override
    public String toString() {
        return "Payment:\n" + purchases.stream().map(Purchase::toString).reduce("", String::concat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment other = (Payment) o;
        return Objects.equals(purchases, other.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchases);
    }


}
