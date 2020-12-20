package com.epam.aggregationandcomposition.entity.travelvoucher;

public enum Transport {

    NONE(0.0),
    BUS(0.15),
    TRAIN(0.25),
    AIRPLANE(0.35);

    private double transportationCostPerKm;

    Transport(double transportationCostPerKm) {
        this.transportationCostPerKm = transportationCostPerKm;
    }

    public double getTransportationCostPerKm() {
        return transportationCostPerKm;
    }
}
