/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seating;

import persontypes.Person;

/**
 *
 * People can sit in the toilet as their seat. Needs to be limited to men and
 * women with a check (either in this class or in the passenger class, whatever
 * makes sense, not children or infants. Has a fixed arm.
 *
 */
public class ToiletSeat extends Seat {

    private Person passenger;

    public ToiletSeat(String seatNumber, int arm, int ssRow) {
        super(seatNumber, arm, ssRow); //Row 18
    }

    @Override
    public void addPassenger(Person person) {
        if (person.canToilet()) {
            this.passenger = person;
            System.out.println(person + " added to seat " + this.getSeatNumber() + " with " + person.getBagWeight() + " lbs of luggage");
            super.setHasPassenger(true);
        } else {
            System.out.println("Child and Infant can't go in the toilet");
            super.setHasPassenger(false);
        }
    }

    @Override
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
