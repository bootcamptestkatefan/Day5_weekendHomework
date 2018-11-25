package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = this.parkingLot.assign(car);
        this.lastErrorMessage = null;
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        //imput ticket, return car
        Car car = this.parkingLot.fetch(ticket);
        if (ticket == null) {
            this.lastErrorMessage = "親，你的票在哪?";
        } else if (ticket.getUsed()){
            this.lastErrorMessage = "親，你的票用過了。";
        } else {
            if (car == null) {
                this.lastErrorMessage = "親，你拿錯票了。";
            } else {
                this.lastErrorMessage = null;
                ticket.setUsed(true);
            }
        }
        return car;
        // TODO: Please implement the method
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
