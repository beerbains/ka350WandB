/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuel;

/**
 * Contains the required fuel elements used to calculate weights, etc
 */
public class Fuel {

    private int rampFuel;
    private String rampFuelCell;
    private String suttoCell;
    private String routeFuelCell;
    private int sutto;
    private int routeFuel;
    private int takeOffFuel;
    private int landingFuel;
    private FuelMoments fuelMoments;

    public Fuel() {
    }

    public Fuel(int rampFuel, int sutto, int routeFuel) {
        this.rampFuel = rampFuel;
        this.sutto = sutto;
        this.routeFuel = routeFuel;
        this.takeOffFuel = rampFuel - sutto;
        this.landingFuel = rampFuel - sutto - routeFuel;
        this.rampFuelCell = "B35";
        this.suttoCell = "B37";
        this.routeFuelCell = "B39";
        this.fuelMoments = new FuelMoments(this.rampFuel, this.takeOffFuel, this.landingFuel);
    }

    public int getRampFuel() {
        return rampFuel;
    }

    public void setRampFuel(int rampFuel) {
        this.rampFuel = rampFuel;
    }

    public int getSutto() {
        return sutto;
    }

    public void setSutto(int sutto) {
        this.sutto = sutto;
    }

    public int getRouteFuel() {
        return routeFuel;
    }

    public void setRouteFuel(int routeFuel) {
        this.routeFuel = routeFuel;
    }

    public String getRampFuelCell() {
        return rampFuelCell;
    }

    public void setRampFuelCell(String rampFuelCell) {
        this.rampFuelCell = rampFuelCell;
    }

    public String getSuttoCell() {
        return suttoCell;
    }

    public void setSuttoCell(String suttoCell) {
        this.suttoCell = suttoCell;
    }

    public String getRouteFuelCell() {
        return routeFuelCell;
    }

    public void setRouteFuelCell(String routeFuelCell) {
        this.routeFuelCell = routeFuelCell;
    }

    public int getTakeOffFuel() {
        return takeOffFuel;
    }

    public void setTakeOffFuel(int takeOffFuel) {
        this.takeOffFuel = takeOffFuel;
    }

    public int getLandingFuel() {
        return landingFuel;
    }

    public void setLandingFuel(int landingFuel) {
        this.landingFuel = landingFuel;
    }

    public FuelMoments getFuelMoments() {
        return fuelMoments;
    }

    public void setFuelMoments(FuelMoments fuelMoments) {
        this.fuelMoments = fuelMoments;
    }
    
    
    
    

}
