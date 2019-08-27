package weightandbalanceapp;

import weight.Weight;
import fuel.Fuel;
import java.util.ArrayList;
import java.util.Random;
import persontypes.Child;
import persontypes.Infant;
import persontypes.Man;
import persontypes.Person;
import persontypes.Woman;
import seating.CockpitSeat;
import seating.PassengerSeat;
import seating.Seat;
import seating.ToiletSeat;
import storagelocations.AdditionalLoad;

/**
 * Contains a constructor and supporting methods for creation of the aircraft
 * object. Stores child objects in associated ArrayLists to aid access and
 * modification. Access to those lists is controlled through getters and setters
 *
 */
public class Aircraft {

    private ArrayList<Seat> seatArray;
    private ArrayList<AdditionalLoad> additionalLoadArray;
    private Fuel fuel;
    private int aircraftNumber;
    private double aircraftEmptyWeight;
    private double aircraftEmptyArm;
    private ArrayList<Weight> weightArray;
    public int POB;
    public double additionalPayloadAvailable;
    private double cockpitBagsWeight = 0;

    public Aircraft(int tailNumber, double aircraftEmptyWeight, double aircraftEmptyArm) {
        this.seatArray = new ArrayList<Seat>();
        this.additionalLoadArray = new ArrayList<AdditionalLoad>();
        this.weightArray = new ArrayList<Weight>();
        this.createSeats();
        this.setSeatArm();
        this.createAdditionalLoadCabinets();
        this.setAircraft(tailNumber, aircraftEmptyWeight, aircraftEmptyArm);
        System.out.println("Aircraft tail number " + this.getAircraftNumber() + " created\n");
    }

    /**
     * Fixed values in the spreadsheet so fixed values for the aircraft object.
     * At the bottom adds an aircraft base weight to the weight array.
     */
    public void setAircraft(int tailNumber, double aircraftEmptyWeight, double aircraftEmptyArm) {
        double aircraftEmptyMoment = 0;
            this.aircraftNumber = tailNumber;
            this.aircraftEmptyWeight = aircraftEmptyWeight;
            this.aircraftEmptyArm = aircraftEmptyArm;
            aircraftEmptyMoment = aircraftEmptyWeight * aircraftEmptyArm / 100;
        this.weightArray.add(new Weight(aircraftEmptyWeight, aircraftEmptyArm, aircraftEmptyMoment, "AircraftEmpty"));
    }

    public void createSeats() {
        CockpitSeat cockpit = new CockpitSeat("Cockpit", 129, 8);
        cockpit.setArm(129);
        this.seatArray.add(cockpit);
        int rowCounter = 9;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    String seatName = Integer.toString(i) + "A";
                    PassengerSeat newSeat = new PassengerSeat(seatName, 0, rowCounter);
                    this.seatArray.add(newSeat);
                    rowCounter++;
                } else {
                    String seatName = Integer.toString(i) + "B";
                    PassengerSeat newSeat = new PassengerSeat(seatName, 0, rowCounter);
                    this.seatArray.add(newSeat);
                    rowCounter++;
                }
            }
        }
        ToiletSeat toilet = new ToiletSeat("Toilet", 327, 18);
        toilet.setArm(327);
        this.seatArray.add(toilet);
        System.out.println("Seats created...");
    }

    /**
     * Fixed values in the spreadsheet so fixed values for the aircraft object
     */
    public void setSeatArm() {
        for (Seat seat : this.seatArray) {
            if (seat.getSeatNumber().contains("1")) {
                seat.setArm(174);
            }
            if (seat.getSeatNumber().contains("2")) {
                seat.setArm(216);
            }
            if (seat.getSeatNumber().contains("3")) {
                seat.setArm(247);
            }
            if (seat.getSeatNumber().contains("4")) {
                seat.setArm(292);
            }
        }
        System.out.println("Seat arm assigned...");
    }

    public void addPassengersToSeats(int numberOfPassengers) {  // roll a random int for weight and for type of person
        for (int i = 1; i < numberOfPassengers + 1; i++) {
            Person person = new Man("Passenger", 15);
            Seat currentSeat = this.getSeatArray().get(i);
            currentSeat.addPassenger(person);
            this.POB++;
        }
    }

    /**
     * Generates passengers randomly based on how many are requested by
     * user/rngIO and what type is generated randomly too. Increases POB to
     * account for any exceedences and for the W&B card.
     *
     * Didn't use a switch statement because we are discouraged from using them.
     */
    public void addRNGPassengersToSeats(int numberOfPassengers) { /// this is a bit wack, would need a decent rewrite to use the addPassenger as a atomic state checker, but I don't know if that will actually work or now
        for (int i = 1; i < numberOfPassengers + 1; i++) {
            Random rand = new Random();
            int seatNumber = rand.nextInt(9) + 1;
            while (this.getSeatArray().get(seatNumber).isHasPassenger()) {
                seatNumber = rand.nextInt(9) + 1;
            }
            int passengerType = rand.nextInt(4) + 1;
            Seat currentSeat = this.getSeatArray().get(seatNumber);
            if (seatNumber == 9) {
                int toiletPassengerType = rand.nextInt(2) + 1;
                if (toiletPassengerType == 1) {
                    int bagWeight = rand.nextInt(15) + 0;
                    Person man = new Man("Man", bagWeight);
                    currentSeat.addPassenger(man);
                }
                if (toiletPassengerType == 2) {
                    int bagWeight = rand.nextInt(15) + 0;
                    Person woman = new Woman("Woman", bagWeight);
                    currentSeat.addPassenger(woman);
                }
                this.POB++;
            } else {
                if (passengerType == 1) {
                    int bagWeight = rand.nextInt(15) + 0;
                    Person man = new Man("Man", bagWeight);
                    currentSeat.addPassenger(man);
                }
                if (passengerType == 2) {
                    int bagWeight = rand.nextInt(15) + 0;
                    Person woman = new Woman("Woman", bagWeight);
                    currentSeat.addPassenger(woman);
                }
                if (passengerType == 3) {
                    int bagWeight = rand.nextInt(15) + 0;
                    Person child = new Child("Child", bagWeight);
                    currentSeat.addPassenger(child);
                }
                if (passengerType == 4) {
                    int bagWeight = rand.nextInt(15) + 0;
                    Person infant = new Infant("Infant", bagWeight);
                    currentSeat.addPassenger(infant);
                }
                this.POB++;
            }
        }
    }

    /**
     *
     * Generates a user defined amount of pilots, throws an exception which
     * isn't caught. That's legacy code from when I started because I was having
     * issues preventing this from crashing and I needed something to trace.
     */
    public void addPilotsToCockpit(int numberOfPilots) { // roll a random int for weight and for type of person
        if (numberOfPilots > 2) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < numberOfPilots; i++) {
                Person pilot = new Man("Pilot", 15);
                this.getSeatArray().get(0).addPassenger(pilot);
                this.POB++;
            }
        }
    }

    /**
     *
     * Generates a random defined amount of pilots, throws an exception which
     * isn't caught. That's legacy code from when I started because I was having
     * issues preventing this from crashing and I needed something to trace.
     */
    public void addRNGPilotsToCockpit(int numberOfPilots) {
        if (numberOfPilots > 2) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < numberOfPilots; i++) {
                Random rand = new Random();
                int pilotType = rand.nextInt(3) + 1;
                if (pilotType == 1) {
                    int bagWeight = rand.nextInt(20) + 0;
                    Person pilot = new Man("Pilot", bagWeight);
                    this.getSeatArray().get(0).addPassenger(pilot);
                    this.POB++;
                    cockpitBagsWeight = cockpitBagsWeight+ bagWeight;
                }
                if (pilotType == 2) {
                    int bagWeight = rand.nextInt(20) + 0;
                    Person pilot = new Woman("Pilot", bagWeight);
                    this.getSeatArray().get(0).addPassenger(pilot);
                    this.POB++;
                    cockpitBagsWeight = cockpitBagsWeight+ bagWeight;
                }
                if (pilotType == 3) {
                    int bagWeight = rand.nextInt(20) + 0;
                    Person pilot = new Child("Pilot", bagWeight);
                    this.getSeatArray().get(0).addPassenger(pilot);
                    this.POB++;
                    cockpitBagsWeight = cockpitBagsWeight+ bagWeight;
                }

            }
        }
    }

    /**
     *
     * IMPORTANT CLASS: generates all of the weights and moments for the other
     * aircraft states. Iterates through all of the associated lists that have
     * weight, and adds it to a total before assigning it to the Weight classes.
     * It's a bit over complicated and long, but it works. Additional payload
     * available is a cell on the spreadsheet that is useful to work out if the
     * plane is overweight or not.
     */
    public void calculateWeightsAndMoments() {
        double runningWeightInSeatTotal = 0;
        double runningSeatMomentTotal = 0;
        for (int i = 1; i < this.getSeatArray().size(); i++) {
            Seat currentSeat = this.getSeatArray().get(i);
            if (currentSeat.isHasPassenger()) {
                currentSeat.setSeatMoment(currentSeat.calculateSeatMoment());
                double totalWeight = currentSeat.getPassenger()[0].getTotalWeight();
                currentSeat.setSeatWeight(totalWeight);
                runningWeightInSeatTotal += totalWeight;
                double seatMoment = currentSeat.getSeatMoment();
                runningSeatMomentTotal += seatMoment;
            }
        }
        runningWeightInSeatTotal = runningWeightInSeatTotal + this.getSeatArray().get(0).getSeatWeight();
        runningSeatMomentTotal = runningSeatMomentTotal + this.getSeatArray().get(0).calculateSeatMoment();
        double runningWeightInAdditionalLoadTotal = 0;
        double runningMomentInAdditionalLoadTotal = 0;

        for (int i = 0; i < this.getAdditionalLoadArray().size(); i++) {
            AdditionalLoad load = this.getAdditionalLoadArray().get(i);
            if (load.getWeight() > 0) {
                runningWeightInAdditionalLoadTotal += load.getWeight();
                double loadMoment = load.calculateLoadMoment();
                runningMomentInAdditionalLoadTotal += loadMoment;
            }
        }
        double totalWeight = runningWeightInSeatTotal + runningWeightInAdditionalLoadTotal + this.weightArray.get(0).getWeight();
        double totalMoment = runningMomentInAdditionalLoadTotal + runningSeatMomentTotal + this.getWeightArray().get(0).getMoment();
        //changed by Beer @ 15 Aug 19, 0916 h, changed zero fuel and take-off arm from '0' to moment*100/weight
        this.weightArray.add(new Weight(totalWeight, 0, totalMoment, "ZeroFuel"));
        this.weightArray.add(new Weight(totalWeight + this.getFuel().getRampFuel(), 0, totalMoment + this.getFuel().getFuelMoments().getRampFuelMoment(), "Ramp"));
        this.weightArray.add(new Weight(totalWeight + this.getFuel().getTakeOffFuel(), 0, totalMoment + this.getFuel().getFuelMoments().getTakeOffFuelMoment(), "TakeOff"));
        this.weightArray.add(new Weight(totalWeight + this.getFuel().getLandingFuel(), 0, totalMoment + this.getFuel().getFuelMoments().getLandingFuelMoment(), "Landing"));
      
        double one = 12500 - totalWeight;
        double two = 15000 - (totalWeight + this.getFuel().getTakeOffFuel());

        this.additionalPayloadAvailable = Math.round(Math.min(one, two));

    }

    /**
     *
     * Creates empty cabinets
     */
    public void createAdditionalLoadCabinets() {
        this.additionalLoadArray.add(new AdditionalLoad("ChartCab", 0, 148, "F20", true));
        this.additionalLoadArray.add(new AdditionalLoad("RHFwdCab", 0, 155, "F21", true));
        this.additionalLoadArray.add(new AdditionalLoad("Rations", 0, 156, "F22", true));
        this.additionalLoadArray.add(new AdditionalLoad("LHFwdCab", 0, 156, "F23", true));
        this.additionalLoadArray.add(new AdditionalLoad("MidCab", 0, 232, "F24", true));
        this.additionalLoadArray.add(new AdditionalLoad("AftCab", 0, 309, "F25", true));
        this.additionalLoadArray.add(new AdditionalLoad("AftCargo", 0, 359, "F19", true));
        System.out.println("Additional load cabinets created and arm assigned...");
    }

    /**
     *
     * Populates the cabinets with weights, can randomly over weight the
     * aircraft for proof of flags//ZERO COG AFT FLAG
     */
    public void addRNGAdditionalLoadCabinets() {
        Random rand = new Random();
        int numberOfLoads = rand.nextInt(7) + 0;
        for (int i = 0; i < numberOfLoads; i++) {
            int typeOfLoad = rand.nextInt(7) + 0;
            while (this.additionalLoadArray.get(typeOfLoad).getWeight() != 0) {
                typeOfLoad = rand.nextInt(6) + 0;
            }
            if (typeOfLoad == 0) {
                int loadWeight = rand.nextInt(44) + 1;
                this.additionalLoadArray.get(0).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(0).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
            if (typeOfLoad == 1) {
                int loadWeight = rand.nextInt(16) + 1;
                this.additionalLoadArray.get(1).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(1).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
            if (typeOfLoad == 2) {
                int loadWeight = rand.nextInt(16) + 1;
                this.additionalLoadArray.get(2).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(2).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
            if (typeOfLoad == 3) {
                int loadWeight = rand.nextInt(101) + 1;
                this.additionalLoadArray.get(3).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(3).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
            if (typeOfLoad == 4) {
                int loadWeight = rand.nextInt(116) + 1;
                this.additionalLoadArray.get(4).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(4).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
            if (typeOfLoad == 5) {
                int loadWeight = rand.nextInt(68) + 1;
                this.additionalLoadArray.get(5).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(5).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
            if (typeOfLoad == 6) {
                int loadWeight = rand.nextInt(1975) + 1;
                this.additionalLoadArray.get(6).setWeight(loadWeight);
                System.out.println(this.additionalLoadArray.get(6).getLocationName() + " loaded with " + loadWeight + " lbs");
            }
        }
    }

    /**
     *
     * creates up to 3 slots for additional additional load (cells H-I 26-33).
     * Creates loads and arms within limits. can randomly over weight the
     * aircraft for proof of flags
     */
    public void addRNGAdditionalLoad() {
        Random rand = new Random();
        int numberOfLoads = rand.nextInt(3) + 0;
        int counter = 0;
        for (int i = 0; i < numberOfLoads; i++) {
            int loadWeight = rand.nextInt(500) + 1;
            int loadArm = rand.nextInt(230) + 129;
            this.additionalLoadArray.add(new AdditionalLoad("Additional " + i, loadWeight, loadArm, ("H" + (26 + counter)), false));
            System.out.println("Additional" + i + " loaded with " + loadWeight + " lbs at arm "+loadArm);
            counter++;
        }
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
        System.out.println("Fuel Loaded into System");
        System.out.println("Ramp: " + fuel.getRampFuel() + " SUTTO: " + fuel.getSutto() + " Landing: " + fuel.getLandingFuel());
        System.out.println("");

    }

    public ArrayList<Seat> getSeatArray() {
        return seatArray;
    }

    public void setSeatArray(ArrayList<Seat> seatArray) {
        this.seatArray = seatArray;
    }

    public ArrayList<AdditionalLoad> getAdditionalLoadArray() {
        return additionalLoadArray;
    }

    public void setAdditionalLoadArray(ArrayList<AdditionalLoad> additionalLoadArray) {
        this.additionalLoadArray = additionalLoadArray;
    }

    public int getAircraftNumber() {
        return aircraftNumber;
    }
    
    public double getAircraftEmptyWeight() {
        return aircraftEmptyWeight;
    }
    
    public double getAircraftEmptyArm() {
        return aircraftEmptyArm;
    }

    public void setAircraftNumber(int aircraftNumber) {
        this.aircraftNumber = aircraftNumber;
    }

    public ArrayList<Weight> getWeightArray() {
        return weightArray;
    }

    public void setWeightArray(ArrayList<Weight> weightArray) {
        this.weightArray = weightArray;
    }

    public int getPOB() {
        return POB;
    }
    
    public double getCockpitBagsWeight() {
        return cockpitBagsWeight;
    }

    public void setPOB(int POB) {
        this.POB = POB;
    }

    public double getAdditionalPayloadAvailable() {
        return additionalPayloadAvailable;
    }

    public void setAdditionalPayloadAvailable(double additionalPayloadAvailable) {
        this.additionalPayloadAvailable = additionalPayloadAvailable;
    }

}
