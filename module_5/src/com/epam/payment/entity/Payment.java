package com.epam.payment.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {

    private final List<Purchase> purchases;

    public Payment() {
        purchases = new ArrayList<>();
    }

    public void addPurchase(String name, BigDecimal pricePerPiece, int numberOfPieces) throws IllegalArgumentException,
            NullPointerException {
        Objects.requireNonNull(name, "The name of the purchase can't be null!");
        Objects.requireNonNull(pricePerPiece, "The price per piece can't be null!");
        if (name.length() > 0 && pricePerPiece.compareTo(BigDecimal.ZERO) > 0 && numberOfPieces > 0) {
            this.purchases.add(new Purchase(name, pricePerPiece, numberOfPieces));
        } else {
        throw new IllegalArgumentException("Incorrect parameters. Can't add the purchase!");
        }
    }

    public void removePurchase(int index) throws IllegalArgumentException {
        if (purchases.size() > 0 && index >= 0 && index < purchases.size() - 1) {
            purchases.remove(index);
        } else {
            throw new IllegalArgumentException("Can't remove a purchase because item with the specified index does " +
                    "not exist!");
        }
    }

    public void removeLastPurchase() throws IllegalArgumentException {
        if (purchases.size() > 0) {
            purchases.remove(purchases.size() - 1);
        } else {
            throw new IllegalArgumentException("Can't remove the last purchase because it does not exist!");
        }
    }

    public int countPurchases() {
        return purchases.size();
    }

    public BigDecimal getTotalAmount() {
        return purchases.stream().map(Purchase::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private class Purchase {

        private String name;
        private BigDecimal pricePerPiece;
        private int numberOfPieces;
        private BigDecimal totalPrice;

        private Purchase(String name, BigDecimal pricePerPiece, int numberOfPieces) {
            this.name = name;
            this.pricePerPiece = pricePerPiece;
            this.numberOfPieces = numberOfPieces;
            this.totalPrice = pricePerPiece.multiply(BigDecimal.valueOf(numberOfPieces));
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = Objects.requireNonNull(name, "The name of the purchase can't be null!");
        }

        private BigDecimal getPricePerPiece() {
            return pricePerPiece;
        }

        private void setPricePerPiece(BigDecimal pricePerPiece) {
            this.pricePerPiece = Objects.requireNonNull(pricePerPiece, "The price per piece of the purchase " +
                    "can't be null!");
        }

        private int getNumberOfPieces() {
            return numberOfPieces;
        }

        private void setNumberOfPieces(int numberOfPieces) {
            this.numberOfPieces = numberOfPieces;
        }

        private BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = Objects.requireNonNull(totalPrice, "The total price of the purchase  can't be null!");
        }

        @Override
        public String toString() {
            return "Purchase [" + name +
                    "; price per piece: " + pricePerPiece +
                    "; number of pieces: " + numberOfPieces +
                    "; price: " + totalPrice +
                    "]\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Purchase other = (Purchase) o;
            return numberOfPieces == other.numberOfPieces &&
                    Objects.equals(name, other.name) &&
                    Objects.equals(pricePerPiece, other.pricePerPiece) &&
                    Objects.equals(totalPrice, other.totalPrice);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, pricePerPiece, numberOfPieces, totalPrice);
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
