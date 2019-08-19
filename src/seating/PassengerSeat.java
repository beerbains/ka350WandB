/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seating;

import persontypes.Person;

/**
 * Generic passenger seat type. Has a fixed arm and will contain one passenger.
 */
public class PassengerSeat extends Seat {

    private Person passenger;

    public PassengerSeat(String seatNumber, int arm, int ssRow) {
        super(seatNumber, arm, ssRow); //Row 9 - 16
    }

    @Override
    public void addPassenger(Person person) {
        this.passenger = person;
        super.setHasPassenger(true);
        System.out.println(person + " added to seat " + this.getSeatNumber() + " with " + person.getBagWeight() + " lbs of luggage");
        super.setHasPassenger(true);
    }

    @Override  //could move to the abstract class with passenger and just override with the cockpit one
    public double calculateSeatMoment() {
        double totalWeight = passenger.getBagWeight() + passenger.getWeight();
        double seatMoment = totalWeight * super.getArm() / 100;
        return seatMoment;
    }

    @Override
    public Person[] getPassenger() {
        Person[] personArray = {this.passenger};
        return personArray;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }

    public void removePassenger() {
        this.passenger = null;
    }

}
