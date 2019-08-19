package weightandbalanceapp;

/**
 *
 * Takes the vars from the spreadsheet card area and adds them to this massive comparison class
 *
 */
public class SpreadsheetCard {

    private SpreadsheetIO ssio;

    private int pob;
    private boolean pobFlag = false;

    private double zeroFuelWeight;
    private boolean zeroFuelOverWeightFlag = false;
    private double zeroFuelMinCog;
    private double zeroFuelCog;
    private double zeroFuelMaxCog;
    private double zeroFuelMac;
    private double zeroFuelRange;
    private boolean zeroFuelFwdCogFlag = false;
    private boolean zeroFuelAftCogFlag = false;
    private boolean zeroFuelExceededCogFlag = false;

    private double takeOffWeight;
    private boolean takeOffOverWeightFlag = false;
    private double takeOffMinCog;
    private double takeOffCog;
    private double takeOffMaxCog;
    private double takeOffMac;
    private double takeOffRange;
    private boolean takeOffFwdCogFlag = false;
    private boolean takeOffAftCogFlag = false;
    private boolean takeOffExceededCogFlag = false;

    private double landingWeight;
    private boolean reservesFlag = false;
    private boolean noFuelFlag = false;
    private double landingMinCog;
    private double landingCog;
    private double landingMaxCog;
    private double landingMac;
    private double landingRange;
    private boolean landingFwdCogFlag = false;
    private boolean landingAftCogFlag = false;
    private boolean landingExceededCogFlag = false;

    public SpreadsheetCard(SpreadsheetIO ssio) {
        this.ssio = ssio;

        double tempPob = ssio.readCell("H49");
        this.pob = (int) tempPob;
        if ((ssio.readStringCell("J49").equals("Check"))) {
            this.pobFlag = true;
        }

        this.zeroFuelWeight = ssio.readCell("C53");
        if (ssio.readStringCell("D53").equals("Exceeded")) {
            this.zeroFuelOverWeightFlag = true;
        }
        this.zeroFuelMinCog = ssio.readCell("E53");
        this.zeroFuelCog = ssio.readCell("F53");
        this.zeroFuelMaxCog = ssio.readCell("I53");
        this.zeroFuelMac = ssio.readCell("G53");
        this.zeroFuelRange = ssio.readCell("H53");
        if (ssio.readStringCell("J53").equals("Exceeded")) {
            zeroFuelExceededCogFlag = true;
        }
        if ((ssio.readStringCell("J53").equals("Fwd"))) {
            zeroFuelFwdCogFlag = true;
        }
        if ((ssio.readStringCell("J53").equals("Aft"))) {
            zeroFuelAftCogFlag = true;
        }

        this.takeOffWeight = ssio.readCell("C55");
        if (ssio.readStringCell("D55").equals("Exceeded")) {
            this.takeOffOverWeightFlag = true;
        }
        this.takeOffMinCog = ssio.readCell("E55");
        this.takeOffCog = ssio.readCell("F55");
        this.takeOffMaxCog = ssio.readCell("I55");
        this.takeOffMac = ssio.readCell("G55");
        this.takeOffRange = ssio.readCell("H55");
        if (ssio.readStringCell("J55").equals("Exceeded")) {
            takeOffExceededCogFlag = true;
        }
        if ((ssio.readStringCell("J55").equals("Fwd"))) {
            takeOffFwdCogFlag = true;
        }
        if ((ssio.readStringCell("J55").equals("Aft"))) {
            takeOffAftCogFlag = true;
        }

        this.landingWeight = ssio.readCell("C57");
        if (ssio.readStringCell("D57").equals("Reserves")) {
            this.reservesFlag = true;
        }
        if (ssio.readStringCell("D57").equals("No Fuel")) {
            this.noFuelFlag = true;
        }
        this.landingMinCog = ssio.readCell("E57");
        this.landingCog = ssio.readCell("F57");
        this.landingMaxCog = ssio.readCell("I57");
        this.landingMac = ssio.readCell("G57");
        this.landingRange = ssio.readCell("H57");
        if (ssio.readStringCell("J57").equals("Exceeded")) {
            landingExceededCogFlag = true;
        }
        if ((ssio.readStringCell("J57").equals("Fwd"))) {
            landingFwdCogFlag = true;
        }
        if ((ssio.readStringCell("J57").equals("Aft"))) {
            landingAftCogFlag = true;
        }
    }

    public SpreadsheetIO getSsio() {
        return ssio;
    }

    public void setSsio(SpreadsheetIO ssio) {
        this.ssio = ssio;
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
