package weightandbalanceapp;

/**
 *
 * Takes the vars from the aircraft classes and adds them to this massive comparison class
 *
 */
public class AircraftCard {

    private Aircraft aircraft;
    private int pob;
    private double cockpitWeightTotal;
    private boolean pobFlag = false;

    private double zeroFuelWeight;
    private double takeOffWeight;
    private double landingWeight;

    private boolean zeroFuelOverWeightFlag = false;
    private boolean takeOffOverWeightFlag = false;
    private boolean reservesFlag = false;
    private boolean noFuelFlag = false;

    private double zeroFuelMinCog;
    private double zeroFuelCog;
    private double zeroFuelMaxCog;
    private double zeroFuelMac;
    private double zeroFuelRange;

    private double takeOffMinCog;
    private double takeOffCog;
    private double takeOffMaxCog;
    private double takeOffMac;
    private double takeOffRange;

    private double landingMinCog;
    private double landingCog;
    private double landingMaxCog;
    private double landingMac;
    private double landingRange;

    private boolean zeroFuelFwdCogFlag = false;
    private boolean zeroFuelAftCogFlag = false;
    private boolean zeroFuelExceededCogFlag = false;

    private boolean takeOffFwdCogFlag = false;
    private boolean takeOffAftCogFlag = false;
    private boolean takeOffExceededCogFlag = false;

    private boolean landingFwdCogFlag = false;
    private boolean landingAftCogFlag = false;
    private boolean landingExceededCogFlag = false;


    public AircraftCard(Aircraft aircraft) {
        this.aircraft = aircraft;
        this.cockpitWeightTotal = aircraft.getCockpitBagsWeight();
        this.pob = aircraft.getPOB();
        if (this.pob < 0 || this.pob > 10 || cockpitWeightTotal>20) {
            this.pobFlag = true;
        }


        this.zeroFuelWeight = aircraft.getWeightArray().get(1).getWeight();
        if (this.zeroFuelWeight > 12500) {
            this.zeroFuelOverWeightFlag = true;
        }
        this.zeroFuelMinCog = aircraft.getWeightArray().get(1).getCogValues().getMincog();
        this.zeroFuelCog = aircraft.getWeightArray().get(1).getCogValues().getCog();
        this.zeroFuelMaxCog = aircraft.getWeightArray().get(1).getCogValues().getMaxcog();
        this.zeroFuelMac = aircraft.getWeightArray().get(1).getCogValues().getMac();
        this.zeroFuelRange = aircraft.getWeightArray().get(1).getCogValues().getRange();
        if (this.zeroFuelCog < this.zeroFuelMinCog) {
            this.zeroFuelExceededCogFlag = true;
        }
        if (this.zeroFuelCog > this.zeroFuelMaxCog) {
            this.zeroFuelExceededCogFlag = true;
        }
        if (this.zeroFuelCog < this.zeroFuelMinCog + 2 && this.zeroFuelCog > this.zeroFuelMinCog) {
            this.zeroFuelFwdCogFlag = true;
        }
        if (this.zeroFuelCog > this.zeroFuelMaxCog - 2 && this.zeroFuelCog < this.zeroFuelMaxCog) {
            this.zeroFuelAftCogFlag = true;
        }


        this.takeOffWeight = aircraft.getWeightArray().get(3).getWeight();
        if (this.takeOffWeight > 15000) {
            this.takeOffOverWeightFlag = true;
        }
        this.takeOffMinCog = aircraft.getWeightArray().get(3).getCogValues().getMincog();
        this.takeOffCog = aircraft.getWeightArray().get(3).getCogValues().getCog();
        this.takeOffMaxCog = aircraft.getWeightArray().get(3).getCogValues().getMaxcog();
        this.takeOffMac = aircraft.getWeightArray().get(3).getCogValues().getMac();
        this.takeOffRange = aircraft.getWeightArray().get(3).getCogValues().getRange();
        if (this.takeOffCog < this.takeOffMinCog) {
            this.takeOffExceededCogFlag = true;
        }
        if (this.takeOffCog > this.takeOffMaxCog) {
            this.takeOffExceededCogFlag = true;
        }
        if (this.takeOffCog < this.takeOffMinCog + 2 && this.takeOffCog > this.takeOffMinCog) {
            this.takeOffFwdCogFlag = true;
        }
        if (this.takeOffCog > this.takeOffMaxCog - 2 && this.takeOffCog < this.takeOffMaxCog) {
            this.takeOffAftCogFlag = true;
        }

        this.landingWeight = aircraft.getWeightArray().get(4).getWeight();
        if (aircraft.getFuel().getLandingFuel() < 100) {
            this.noFuelFlag = true;
        }
        if (aircraft.getFuel().getLandingFuel() >= 100 && aircraft.getFuel().getLandingFuel() < 500) {
            this.reservesFlag = true;
        }
        this.landingMinCog = aircraft.getWeightArray().get(4).getCogValues().getMincog();
        this.landingCog = aircraft.getWeightArray().get(4).getCogValues().getCog();
        this.landingMaxCog = aircraft.getWeightArray().get(4).getCogValues().getMaxcog();
        this.landingMac = aircraft.getWeightArray().get(4).getCogValues().getMac();
        this.landingRange = aircraft.getWeightArray().get(4).getCogValues().getRange();
        if (this.landingCog < this.landingMinCog) {
            this.landingExceededCogFlag = true;
        }
        if (this.landingCog > this.landingMaxCog) {
            this.landingExceededCogFlag = true;
        }
        if (this.landingCog < this.landingMinCog + 2 && this.landingCog > this.landingMinCog) {
            this.landingFwdCogFlag = true;
        }
        if (this.landingCog > this.landingMaxCog - 2 && this.landingCog < this.landingMaxCog) {
            this.landingAftCogFlag = true;
        }
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public int getPob() {
        return pob;
    }

    public void setPob(int pob) {
        this.pob = pob;
    }

    public boolean isPobFlag() {
        return pobFlag;
    }

    public void setPobFlag(boolean pobFlag) {
        this.pobFlag = pobFlag;
    }

    public double getZeroFuelWeight() {
        return zeroFuelWeight;
    }

    public void setZeroFuelWeight(double zeroFuelWeight) {
        this.zeroFuelWeight = zeroFuelWeight;
    }

    public double getTakeOffWeight() {
        return takeOffWeight;
    }

    public void setTakeOffWeight(double takeOffWeight) {
        this.takeOffWeight = takeOffWeight;
    }

    public double getLandingWeight() {
        return landingWeight;
    }

    public void setLandingWeight(double landingWeight) {
        this.landingWeight = landingWeight;
    }

    public boolean isZeroFuelOverWeightFlag() {
        return zeroFuelOverWeightFlag;
    }

    public void setZeroFuelOverWeightFlag(boolean zeroFuelOverWeightFlag) {
        this.zeroFuelOverWeightFlag = zeroFuelOverWeightFlag;
    }

    public boolean isTakeOffOverWeightFlag() {
        return takeOffOverWeightFlag;
    }

    public void setTakeOffOverWeightFlag(boolean takeOffOverWeightFlag) {
        this.takeOffOverWeightFlag = takeOffOverWeightFlag;
    }

    public boolean isReservesFlag() {
        return reservesFlag;
    }

    public void setReservesFlag(boolean reservesFlag) {
        this.reservesFlag = reservesFlag;
    }

    public boolean isNoFuelFlag() {
        return noFuelFlag;
    }

    public void setNoFuelFlag(boolean noFuelFlag) {
        this.noFuelFlag = noFuelFlag;
    }

    public double getZeroFuelMinCog() {
        return zeroFuelMinCog;
    }

    public void setZeroFuelMinCog(double zeroFuelMinCog) {
        this.zeroFuelMinCog = zeroFuelMinCog;
    }

    public double getZeroFuelCog() {
        return zeroFuelCog;
    }

    public void setZeroFuelCog(double zeroFuelCog) {
        this.zeroFuelCog = zeroFuelCog;
    }

    public double getZeroFuelMaxCog() {
        return zeroFuelMaxCog;
    }

    public void setZeroFuelMaxCog(double zeroFuelMaxCog) {
        this.zeroFuelMaxCog = zeroFuelMaxCog;
    }

    public double getZeroFuelMac() {
        return zeroFuelMac;
    }

    public void setZeroFuelMac(double zeroFuelMac) {
        this.zeroFuelMac = zeroFuelMac;
    }

    public double getZeroFuelRange() {
        return zeroFuelRange;
    }

    public void setZeroFuelRange(double zeroFuelRange) {
        this.zeroFuelRange = zeroFuelRange;
    }

    public double getTakeOffMinCog() {
        return takeOffMinCog;
    }

    public void setTakeOffMinCog(double takeOffMinCog) {
        this.takeOffMinCog = takeOffMinCog;
    }

    public double getTakeOffCog() {
        return takeOffCog;
    }

    public void setTakeOffCog(double takeOffCog) {
        this.takeOffCog = takeOffCog;
    }

    public double getTakeOffMaxCog() {
        return takeOffMaxCog;
    }

    public void setTakeOffMaxCog(double takeOffMaxCog) {
        this.takeOffMaxCog = takeOffMaxCog;
    }

    public double getTakeOffMac() {
        return takeOffMac;
    }

    public void setTakeOffMac(double takeOffMac) {
        this.takeOffMac = takeOffMac;
    }

    public double getTakeOffRange() {
        return takeOffRange;
    }

    public void setTakeOffRange(double takeOffRange) {
        this.takeOffRange = takeOffRange;
    }

    public double getLandingMinCog() {
        return landingMinCog;
    }

    public void setLandingMinCog(double landingMinCog) {
        this.landingMinCog = landingMinCog;
    }

    public double getLandingCog() {
        return landingCog;
    }

    public void setLandingCog(double landingCog) {
        this.landingCog = landingCog;
    }

    public double getLandingMaxCog() {
        return landingMaxCog;
    }

    public void setLandingMaxCog(double landingMaxCog) {
        this.landingMaxCog = landingMaxCog;
    }

    public double getLandingMac() {
        return landingMac;
    }

    public void setLandingMac(double landingMac) {
        this.landingMac = landingMac;
    }

    public double getLandingRange() {
        return landingRange;
    }

    public void setLandingRange(double landingRange) {
        this.landingRange = landingRange;
    }

    public boolean isZeroFuelFwdCogFlag() {
        return zeroFuelFwdCogFlag;
    }

    public void setZeroFuelFwdCogFlag(boolean zeroFuelFwdCogFlag) {
        this.zeroFuelFwdCogFlag = zeroFuelFwdCogFlag;
    }

    public boolean isZeroFuelAftCogFlag() {
        return zeroFuelAftCogFlag;
    }

    public void setZeroFuelAftCogFlag(boolean zeroFuelAftCogFlag) {
        this.zeroFuelAftCogFlag = zeroFuelAftCogFlag;
    }

    public boolean isZeroFuelExceededCogFlag() {
        return zeroFuelExceededCogFlag;
    }

    public void setZeroFuelExceededCogFlag(boolean zeroFuelExceededCogFlag) {
        this.zeroFuelExceededCogFlag = zeroFuelExceededCogFlag;
    }

    public boolean isTakeOffFwdCogFlag() {
        return takeOffFwdCogFlag;
    }

    public void setTakeOffFwdCogFlag(boolean takeOffFwdCogFlag) {
        this.takeOffFwdCogFlag = takeOffFwdCogFlag;
    }

    public boolean isTakeOffAftCogFlag() {
        return takeOffAftCogFlag;
    }

    public void setTakeOffAftCogFlag(boolean takeOffAftCogFlag) {
        this.takeOffAftCogFlag = takeOffAftCogFlag;
    }

    public boolean isTakeOffExceededCogFlag() {
        return takeOffExceededCogFlag;
    }

    public void setTakeOffExceededCogFlag(boolean takeOffExceededCogFlag) {
        this.takeOffExceededCogFlag = takeOffExceededCogFlag;
    }

    public boolean isLandingFwdCogFlag() {
        return landingFwdCogFlag;
    }

    public void setLandingFwdCogFlag(boolean landingFwdCogFlag) {
        this.landingFwdCogFlag = landingFwdCogFlag;
    }

    public boolean isLandingAftCogFlag() {
        return landingAftCogFlag;
    }

    public void setLandingAftCogFlag(boolean landingAftCogFlag) {
        this.landingAftCogFlag = landingAftCogFlag;
    }

    public boolean isLandingExceededCogFlag() {
        return landingExceededCogFlag;
    }

    public void setLandingExceededCogFlag(boolean landingExceededCogFlag) {
        this.landingExceededCogFlag = landingExceededCogFlag;
    }
}
