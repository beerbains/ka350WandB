/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seating;

import persontypes.Person;

/**
 *
 * Cockpit seat type, can have 2 people sitting at the seat. Need to limit this
 * class so infants can't pilot the planeX
 *
 */
public class CockpitSeat extends Seat {

    private Person pilot;
    private Person coPilot;

    public CockpitSeat(String seatNumber, double arm, int ssRow) {
        super(seatNumber, arm, ssRow); // Row 8
    }

    @Override
    public void addPassenger(Person person) {  // change to the iscockpit one
        if (person.canCockpit()) {
            if (this.pilot == null) {
                this.pilot = person;
                System.out.println(person + " added to " + this.getSeatNumber() + " seat, with " + person.getBagWeight() + " lbs of luggage");
                super.setHasPassenger(true);
            } else if (this.coPilot == null) {
                this.coPilot = person;
                System.out.println(person + " added to " + this.getSeatNumber() + " seat, with " + person.getBagWeight() + " lbs of luggage");
                super.setHasPassenger(true);
            } else if (this.pilot != null && this.coPilot != null) {
                System.out.println("Cockpit is full");
            }
        } else {
            System.out.println("Pilot or CoPilot are incorrectly named");
        }
    }

    @Override
    public double calculateSeatMoment() {
        if (this.coPilot == null) {
            double pilotTotalWeight = this.pilot.getBagWeight() + this.pilot.getWeight();
            double seatMoment = (pilotTotalWeight) * super.getArm() / 100;
            super.setSeatMoment(seatMoment);
            return seatMoment;
        } else {
            double pilotTotalWeight = this.pilot.getBagWeight() + this.pilot.getWeight();
            double coPilotTotalWeight = this.coPilot.getBagWeight() + this.coPilot.getWeight();
            double seatMoment = (pilotTotalWeight + coPilotTotalWeight) * super.getArm() / 100;
            super.setSeatMoment(seatMoment);
            return seatMoment;
        }
    }

    @Override
    public double getSeatWeight() {
        if (this.coPilot == null) {
            double pilotTotalWeight = this.pilot.getBagWeight() + this.pilot.getWeight();
            return pilotTotalWeight;
        } else {
            double pilotTotalWeight = this.pilot.getBagWeight() + this.pilot.getWeight();
            double coPilotTotalWeight = this.coPilot.getBagWeight() + this.coPilot.getWeight();
            double weightTotal = (pilotTotalWeight + coPilotTotalWeight);
            return weightTotal;
        }
    }

    @Override
    public Person[] getPassenger() {
        if (this.coPilot == null) {
            Person[] personArray = {this.pilot};
            return personArray;
        } else {
            Person[] personArray = {this.pilot, this.coPilot};
            return personArray;
        }
    }

    public Person getPilot() {
        return pilot;
    }

    public void setPilot(Person pilot) {
        this.pilot = pilot;
    }

    public void removePilot() {
        this.pilot = null;
    }

    public Person getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(Person coPilot) {
        this.coPilot = coPilot;
    }

    public void removeCoPilot() {
        this.coPilot = null;
    }

}
