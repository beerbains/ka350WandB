package weightandbalanceapp;

import fuel.Fuel;
import java.util.Random;
import java.util.Scanner;

public class InputController {

    private Aircraft aircraft;

    /**
     *
     * Use this constructor to switch between UserIO and RNGIO. When learning
     * this code switch if to userIO and remove the for loop from the main
     * function
     *
     *
     */
    public InputController(Aircraft aircraft) {
        this.aircraft = aircraft;
        this.rngIO();
        //this.userIO();
    }

    /**
     * Contains basic IO for tester. Not very in depth functionality as I used
     * if mainly for testing and development. When you come to learn the
     * program, start with this and right click, go to source all of the
     * functions.
     */
    public void userIO() {
        int numberOfPilots = 0;
        int numberOfPassengers = -1;
        Scanner input = new Scanner(System.in);
        aircraft.setFuel(new Fuel(2800, 100, 600));

        while (numberOfPilots != 1 && numberOfPilots != 2) {
            System.out.println("Number of Pilots (1 or 2)");
            numberOfPilots = input.nextInt();
        }
        while (numberOfPassengers > 9 || numberOfPassengers < 0) {
            System.out.println("Number of Passengers (9 or fewer)");
            numberOfPassengers = input.nextInt();
        }
        aircraft.addPilotsToCockpit(numberOfPilots);
        aircraft.addPassengersToSeats(numberOfPassengers);
        aircraft.addRNGAdditionalLoadCabinets();
        aircraft.addRNGAdditionalLoad();
        aircraft.calculateWeightsAndMoments();
        System.out.println();
    }

    /**
     * Contains the RNG for fuel amounts. Calls the functions in the aircraft
     * class to randomly generate the crew, passengers, weights.
     */
    public void rngIO() {
        Random rand = new Random();
        int rampFuel = rand.nextInt(2600) + 1000;
        int sutto = rand.nextInt(150) + 50;
        int routeFuel = rand.nextInt(rampFuel) + 100;

        while ((rampFuel - sutto - routeFuel) <= 0) {
            routeFuel = rand.nextInt(rampFuel) + 100;
        }
        System.out.println("Ramp Fuel: " + rampFuel + " SUTTO: " + sutto + " Route Fuel: " + routeFuel);
        aircraft.setFuel(new Fuel(rampFuel, sutto, routeFuel));
        //aircraft.setFuel(new Fuel(3303, 139, 1204));
        int numberOfPilots = rand.nextInt(2) + 1;
        int numberOfPassengers = rand.nextInt(9) + 0; //add zero 
        aircraft.addRNGPilotsToCockpit(numberOfPilots);
        aircraft.addRNGPassengersToSeats(numberOfPassengers);
        aircraft.addRNGAdditionalLoadCabinets();
        aircraft.addRNGAdditionalLoad();
        aircraft.calculateWeightsAndMoments();
        System.out.println();
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
