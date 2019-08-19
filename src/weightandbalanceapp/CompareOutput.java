package weightandbalanceapp;

public class CompareOutput {

    private Aircraft aircraft;
    private SpreadsheetIO ssio;
    private AircraftCard aircraftCard;
    private SpreadsheetCard ssCard;

    /**
     * Made far simpler, just runs and compares variables between the two Card classes
     */
    public CompareOutput(Aircraft aircraft, SpreadsheetIO ssio, AircraftCard aircraftCard, SpreadsheetCard ssCard) {
        this.aircraft = aircraft;
        this.aircraftCard = aircraftCard;
        this.ssio = ssio;
        this.ssCard = ssCard;
        this.runTests();
    }

    private void runTests() {
        //POB
        System.out.println("==========POB==========");
        if (Math.abs(aircraftCard.getPob() - ssCard.getPob()) == 0) {
            System.out.println("POB\t\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getPob() + " SS: " + ssCard.getPob());
        } else {
            System.out.println("POB\t\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getPob() + " SS: " + ssCard.getPob());
        }
        //POB Flag
        if (aircraftCard.isPobFlag() == ssCard.isPobFlag()) {
            System.out.println("POB FLAG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.isPobFlag() + " SS: " + ssCard.isPobFlag());
        } else {
            System.out.println("POB FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isPobFlag() + " SS: " + ssCard.isPobFlag());
        }

        System.out.println("\n==========ZERO FUEL==========");
        if (aircraftCard.getZeroFuelWeight() == ssCard.getZeroFuelWeight()) {
            System.out.println("ZERO FUEL WEIGHT\t\tTEST PASS" + "\tJava: " + aircraftCard.getZeroFuelWeight() + " SS: " + ssCard.getZeroFuelWeight());
        } else {
            System.out.println("ZERO FUEL WEIGHT\t\tTEST FAIL" + "\tJava: " + aircraftCard.getZeroFuelWeight() + " SS: " + ssCard.getZeroFuelWeight());
        }
        if (aircraftCard.isZeroFuelOverWeightFlag() == ssCard.isZeroFuelOverWeightFlag()) {
            System.out.println("ZERO FUEL FLAG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.isZeroFuelOverWeightFlag() + " SS: " + ssCard.isZeroFuelOverWeightFlag());
        } else {
            System.out.println("ZERO FUEL FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isZeroFuelOverWeightFlag() + " SS: " + ssCard.isZeroFuelOverWeightFlag());
        }
        if (aircraftCard.getZeroFuelMinCog() - ssCard.getZeroFuelMinCog() < 0.00005) {
            System.out.println("ZERO FUEL MIN COG\t\tTEST PASS" + "\tJava: " + aircraftCard.getZeroFuelMinCog() + " SS: " + ssCard.getZeroFuelMinCog());
        } else {
            System.out.println("ZERO FUEL MIN COG\t\tTEST FAIL" + "\tJava: " + aircraftCard.getZeroFuelMinCog() + " SS: " + ssCard.getZeroFuelMinCog());
        }
        if (aircraftCard.getZeroFuelCog() - ssCard.getZeroFuelCog() < 0.00005) {
            System.out.println("ZERO FUEL COG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getZeroFuelCog() + " SS: " + ssCard.getZeroFuelCog());
        } else {
            System.out.println("ZERO FUEL COG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getZeroFuelCog() + " SS: " + ssCard.getZeroFuelCog());
        }
        if (aircraftCard.getZeroFuelMac() - ssCard.getZeroFuelMac() < 0.00005) {
            System.out.println("ZERO FUEL MAC\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getZeroFuelMac() + " SS: " + ssCard.getZeroFuelMac());
        } else {
            System.out.println("ZERO FUEL MAC\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getZeroFuelMac() + " SS: " + ssCard.getZeroFuelMac());
        }
        if (aircraftCard.getZeroFuelRange() - ssCard.getZeroFuelRange() < 0.00005) {
            System.out.println("ZERO FUEL RANGE\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getZeroFuelRange() + " SS: " + ssCard.getZeroFuelRange());
        } else {
            System.out.println("ZERO FUEL RANGE\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getZeroFuelRange() + " SS: " + ssCard.getZeroFuelRange());
        }
        if (aircraftCard.getZeroFuelMaxCog() - ssCard.getZeroFuelMaxCog() < 0.00005) {
            System.out.println("ZERO FUEL MAX COG\t\tTEST PASS" + "\tJava: " + aircraftCard.getZeroFuelMaxCog() + " SS: " + ssCard.getZeroFuelMaxCog());
        } else {
            System.out.println("ZERO FUEL MAX COG\t\tTEST FAIL" + "\tJava: " + aircraftCard.getZeroFuelMaxCog() + " SS: " + ssCard.getZeroFuelMaxCog());
        }
        if (aircraftCard.isZeroFuelExceededCogFlag() == ssCard.isZeroFuelExceededCogFlag()) {
            System.out.println("ZERO COG EXCEEDED FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isZeroFuelExceededCogFlag() + " SS: " + ssCard.isZeroFuelExceededCogFlag());
        } else {
            System.out.println("ZERO COG EXCEEDED FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isZeroFuelExceededCogFlag() + " SS: " + ssCard.isZeroFuelExceededCogFlag());
        }
        if (aircraftCard.isZeroFuelFwdCogFlag() == ssCard.isZeroFuelFwdCogFlag()) {
            System.out.println("ZERO COG FWD FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isZeroFuelFwdCogFlag() + " SS: " + ssCard.isZeroFuelFwdCogFlag());
        } else {
            System.out.println("ZERO COF FWD FLAG\t\tTEST FAIL" + "\tJava: " + aircraftCard.isZeroFuelFwdCogFlag() + " SS: " + ssCard.isZeroFuelFwdCogFlag());
        }
        if (aircraftCard.isZeroFuelAftCogFlag() == ssCard.isZeroFuelAftCogFlag()) {
            System.out.println("ZERO COG AFT FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isZeroFuelAftCogFlag() + " SS: " + ssCard.isZeroFuelAftCogFlag());
        } else {
            System.out.println("ZERO COG AFT FLAG\t\tTEST FAIL" + "\tJava: " + aircraftCard.isZeroFuelAftCogFlag() + " SS: " + ssCard.isZeroFuelAftCogFlag());
        }

        System.out.println("\n==========TAKE OFF==========");
        if (aircraftCard.getTakeOffWeight() == ssCard.getTakeOffWeight()) {
            System.out.println("TAKE OFF WEIGHT\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getTakeOffWeight() + " SS: " + ssCard.getTakeOffWeight());
        } else {
            System.out.println("TAKE OFF WEIGHT\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getTakeOffWeight() + " SS: " + ssCard.getTakeOffWeight());
        }
        if (aircraftCard.isTakeOffOverWeightFlag() == ssCard.isTakeOffOverWeightFlag()) {
            System.out.println("TAKE OFF FLAG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.isTakeOffOverWeightFlag() + " SS: " + ssCard.isTakeOffOverWeightFlag());
        } else {
            System.out.println("TAKE OFF FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isTakeOffOverWeightFlag() + " SS: " + ssCard.isTakeOffOverWeightFlag());
        }
        if (aircraftCard.getTakeOffMinCog() - ssCard.getTakeOffMinCog() < 0.00005) {
            System.out.println("TAKE OFF MIN COG\t\tTEST PASS" + "\tJava: " + aircraftCard.getTakeOffMinCog() + " SS: " + ssCard.getTakeOffMinCog());
        } else {
            System.out.println("TAKE OFF MIN COG\t\tTEST FAIL" + "\tJava: " + aircraftCard.getTakeOffMinCog() + " SS: " + ssCard.getTakeOffMinCog());
        }
        if (aircraftCard.getTakeOffCog() - ssCard.getTakeOffCog() < 0.00005) {
            System.out.println("TAKE OFF COG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getTakeOffCog() + " SS: " + ssCard.getTakeOffCog());
        } else {
            System.out.println("TAKE OFF COG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getTakeOffCog() + " SS: " + ssCard.getTakeOffCog());
        }
        if (aircraftCard.getTakeOffMac() - ssCard.getTakeOffMac() < 0.00005) {
            System.out.println("TAKE OFF MAC\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getTakeOffMac() + " SS: " + ssCard.getTakeOffMac());
        } else {
            System.out.println("TAKE OFF MAC\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getTakeOffMac() + " SS: " + ssCard.getTakeOffMac());
        }
        if (aircraftCard.getTakeOffRange() - ssCard.getTakeOffRange() < 0.00005) {
            System.out.println("TAKE OFF RANGE\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getTakeOffRange() + " SS: " + ssCard.getTakeOffRange());
        } else {
            System.out.println("TAKE OFF RANGE\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getTakeOffRange() + " SS: " + ssCard.getTakeOffRange());
        }
        if (aircraftCard.getTakeOffMaxCog() - ssCard.getTakeOffMaxCog() < 0.00005) {
            System.out.println("TAKE OFF MAX COG\t\tTEST PASS" + "\tJava: " + aircraftCard.getTakeOffMaxCog() + " SS: " + ssCard.getTakeOffMaxCog());
        } else {
            System.out.println("TAKE OFF MAX COG\t\tTEST FAIL" + "\tJava: " + aircraftCard.getTakeOffMaxCog() + " SS: " + ssCard.getTakeOffMaxCog());
        }
        if (aircraftCard.isTakeOffExceededCogFlag() == ssCard.isTakeOffExceededCogFlag()) {
            System.out.println("ZERO COG EXCEEDED FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isTakeOffExceededCogFlag() + " SS: " + ssCard.isTakeOffExceededCogFlag());
        } else {
            System.out.println("ZERO COG EXCEEDED FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isTakeOffExceededCogFlag() + " SS: " + ssCard.isTakeOffExceededCogFlag());
        }
        if (aircraftCard.isTakeOffFwdCogFlag() == ssCard.isTakeOffFwdCogFlag()) {
            System.out.println("ZERO COG FWD FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isTakeOffFwdCogFlag() + " SS: " + ssCard.isTakeOffFwdCogFlag());
        } else {
            System.out.println("ZERO COG FWD FLAG\t\tTEST FAIL" + "\tJava: " + aircraftCard.isTakeOffFwdCogFlag() + " SS: " + ssCard.isTakeOffFwdCogFlag());
        }
        if (aircraftCard.isTakeOffAftCogFlag() == ssCard.isTakeOffAftCogFlag()) {
            System.out.println("ZERO COG AFT FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isTakeOffAftCogFlag() + " SS: " + ssCard.isTakeOffAftCogFlag());
        } else {
            System.out.println("ZERO COG AFT FLAG\t\tTEST FAIL" + "\tJava: " + aircraftCard.isTakeOffAftCogFlag() + " SS: " + ssCard.isTakeOffAftCogFlag());
        }

        System.out.println("\n==========LANDING==========");
        if (aircraftCard.getLandingWeight() == ssCard.getLandingWeight()) {
            System.out.println("LANDING WEIGHT\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getLandingWeight() + " SS: " + ssCard.getLandingWeight());
        } else {
            System.out.println("LANDING WEIGHT\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getLandingWeight() + " SS: " + ssCard.getLandingWeight());
        }
        if (aircraftCard.isNoFuelFlag() == ssCard.isNoFuelFlag()) {
            System.out.println("NO FUEL FLAG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.isNoFuelFlag() + " SS: " + ssCard.isNoFuelFlag());
        } else {
            System.out.println("NO FUEL FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isNoFuelFlag() + " SS: " + ssCard.isNoFuelFlag());
        }
        if (aircraftCard.isReservesFlag() == ssCard.isReservesFlag()) {
            System.out.println("RESERVES FLAG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.isReservesFlag() + " SS: " + ssCard.isReservesFlag());
        } else {
            System.out.println("RESERVES FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isReservesFlag() + " SS: " + ssCard.isReservesFlag());
        }
        if (aircraftCard.getLandingMinCog() - ssCard.getLandingMinCog() < 0.00005) {
            System.out.println("LANDING MIN COG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getLandingMinCog() + " SS: " + ssCard.getLandingMinCog());
        } else {
            System.out.println("LANDING MIN COG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getLandingMinCog() + " SS: " + ssCard.getLandingMinCog());
        }
        if (aircraftCard.getLandingCog() - ssCard.getLandingCog() < 0.00005) {
            System.out.println("LANDING COG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getLandingCog() + " SS: " + ssCard.getLandingCog());
        } else {
            System.out.println("LANDING COG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getLandingCog() + " SS: " + ssCard.getLandingCog());
        }
        if (aircraftCard.getLandingMac() - ssCard.getLandingMac() < 0.00005) {
            System.out.println("LANDING MAC\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getLandingMac() + " SS: " + ssCard.getLandingMac());
        } else {
            System.out.println("LANDING MAC\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getLandingMac() + " SS: " + ssCard.getLandingMac());
        }
        if (aircraftCard.getLandingRange() - ssCard.getLandingRange() < 0.00005) {
            System.out.println("LANDING RANGE\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getLandingRange() + " SS: " + ssCard.getLandingRange());
        } else {
            System.out.println("LANDING RANGE\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getLandingRange() + " SS: " + ssCard.getLandingRange());
        }
        if (aircraftCard.getLandingMaxCog() - ssCard.getLandingMaxCog() < 0.00005) {
            System.out.println("LANDING MAX COG\t\t\tTEST PASS" + "\tJava: " + aircraftCard.getLandingMaxCog() + " SS: " + ssCard.getLandingMaxCog());
        } else {
            System.out.println("LANDING MAX COG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.getLandingMaxCog() + " SS: " + ssCard.getLandingMaxCog());
        }
        if (aircraftCard.isLandingExceededCogFlag() == ssCard.isLandingExceededCogFlag()) {
            System.out.println("ZERO COG EXCEEDED FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isLandingExceededCogFlag() + " SS: " + ssCard.isLandingExceededCogFlag());
        } else {
             System.out.println("ZERO COG EXCEEDED FLAG\t\t\tTEST FAIL" + "\tJava: " + aircraftCard.isLandingExceededCogFlag() + " SS: " + ssCard.isLandingExceededCogFlag());
        }
        if (aircraftCard.isLandingFwdCogFlag() == ssCard.isLandingFwdCogFlag()) {
            System.out.println("ZERO COG FWD FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isLandingFwdCogFlag() + " SS: " + ssCard.isLandingFwdCogFlag());
        } else {
            System.out.println("ZERO COF FWD FLAG\t\tTEST FAIL" + "\tJava: " + aircraftCard.isLandingFwdCogFlag() + " SS: " + ssCard.isLandingFwdCogFlag());
        }
        if (aircraftCard.isLandingAftCogFlag() == ssCard.isLandingAftCogFlag()) {
            System.out.println("ZERO COG AFT FLAG\t\tTEST PASS" + "\tJava: " + aircraftCard.isLandingAftCogFlag() + " SS: " + ssCard.isLandingAftCogFlag());
        } else {
            System.out.println("ZERO COG AFT FLAG\t\tTEST FAIL" + "\tJava: " + aircraftCard.isLandingAftCogFlag() + " SS: " + ssCard.isLandingAftCogFlag());
        }
    }
}
