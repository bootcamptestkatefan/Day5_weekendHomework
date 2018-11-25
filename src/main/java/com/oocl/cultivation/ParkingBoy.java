package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (this.parkingLot.getAvailableParkingPosition() > 0) {
            ParkingTicket ticket = this.parkingLot.assign(car);
            this.lastErrorMessage = null;
            return ticket;
        }
        else {
            this.lastErrorMessage = "親，停車場已滿，你過主啦。";
            return null;
        }
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
