package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TravelVoucherLogicalException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class TravelVoucher {

    private static int counterId = 1;
    private static final double[] TRANSPORTATION_COST_PER_KM = {
            0.15, // BUS
            0.25, // TRAIN
            0.35, // AIRPLANE
    };

    private int id;
    private Tour tour;
    private int numberOfDays;
    private Transport transport;

    public TravelVoucher(Tour tour, int numberOfDays, Transport transport) throws TravelVoucherLogicalException {
        if (tour != null && numberOfDays > 0 && transport != null) {
            this.id = counterId++;
            this.tour = tour;
            this.numberOfDays = numberOfDays;
            this.transport = transport;
        } else {
            throw new TravelVoucherLogicalException("Incorrect parameters. Can't create a travel voucher!");
        }
    }

    public BigDecimal calculateTotalPrice() {
        return tour.getPricePerDayDependingOnMeals().multiply(BigDecimal.valueOf(numberOfDays)).
                add(calculateTransportationCost()).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTransportationCost() {
        BigDecimal transportationCost;
        switch (transport) {
            case BUS:
                transportationCost = BigDecimal.valueOf(tour.getDistance() * TRANSPORTATION_COST_PER_KM[0]);
                break;
            case TRAIN:
                transportationCost = BigDecimal.valueOf(tour.getDistance() * TRANSPORTATION_COST_PER_KM[1]);
                break;
            case AIRPLANE:
                transportationCost = BigDecimal.valueOf(tour.getDistance() * TRANSPORTATION_COST_PER_KM[2]);
                break;
            default:
                transportationCost = BigDecimal.ZERO;
                break;
        }
        return transportationCost;
    }

    public int getId() {
        return id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) throws TravelVoucherLogicalException {
        if (tour != null) {
            this.tour = tour;
        } else {
            throw new TravelVoucherLogicalException("Incorrect parameter. Can't change the tour!");
        }
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) throws TravelVoucherLogicalException {
        if (numberOfDays > 0) {
            this.numberOfDays = numberOfDays;
        } else {
            throw new TravelVoucherLogicalException("Incorrect parameter. Can't change the number of days!");
        }
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) throws TravelVoucherLogicalException {
        if (transport != null) {
            this.transport = transport;
        } else {
            throw new TravelVoucherLogicalException("Incorrect parameter. Can't change the transport type!");
        }
    }

    @Override
    public String toString() {
        return "TravelVoucher [" +
                "id: " + id +
                "; tour: " + tour +
                "; the number of days: " + numberOfDays +
                "; transport: " + transport +
                "]\nThe total price: " + calculateTotalPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelVoucher other = (TravelVoucher) o;
        return id == other.id &&
                numberOfDays == other.numberOfDays &&
                Objects.equals(tour, other.tour) &&
                transport == other.transport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tour, numberOfDays, transport);
    }
}
