/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seating;

import persontypes.Person;

/**
 *
 * Abstract class used to contain all of the associated seat classes. Has 2
 * methods which are required to be overridden in order to establish the
 * necessary polymorphism required to set the Arm, and get the seat numbers
 *
 */
public abstract class Seat {

    private String seatNumber;
    private double arm;
    private double seatMoment;
    private double seatWeight;
    private int ssRow;
    private boolean hasPassenger;

    public Seat(String seatNumber, double arm, int ssRow) {
        this.seatNumber = seatNumber;
        this.arm = arm;
        this.ssRow = ssRow;
        this.hasPassenger = false;
    }

    public abstract double calculateSeatMoment();

    public abstract void addPassenger(Person person);

    public abstract Person[] getPassenger();

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public double getSeatMoment() {
        return seatMoment;
    }

    public void setSeatMoment(double seatMoment) {
        this.seatMoment = seatMoment;
    }

    public double getSeatWeight() {
        return seatWeight;
    }

    public void setSeatWeight(double seatWeight) {
        this.seatWeight = seatWeight;
    }

    public int getSsRow() {
        return ssRow;
    }

    public void setSsRow(int ssRow) {
        this.ssRow = ssRow;
    }

    public boolean isHasPassenger() {
        return hasPassenger;
    }

    public void setHasPassenger(boolean hasPassenger) {
        this.hasPassenger = hasPassenger;
    }

}
