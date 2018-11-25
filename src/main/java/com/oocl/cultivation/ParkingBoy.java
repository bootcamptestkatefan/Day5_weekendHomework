package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = this.parkingLot.assign(car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        //imput ticket, return car
        Car car = this.parkingLot.fetch(ticket);
        return car;
        // TODO: Please implement the method
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
