/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuel;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FuelMoments {

    private double rampFuelMoment;
    private double rampFuelArm;
    private double takeOffFuelMoment;
    private double takeOffFuelArm;
    private double landingFuelMoment;
    private double landingFuelArm;
    private LinkedHashMap<Integer, Integer> fuelLookup;

    public FuelMoments(double rampFuel, double takeOffFuel, double landingFuel) {
        this.fuelLookup = this.generateFuelLookup();
        this.rampFuelMoment = this.calculateFuelMoment(rampFuel);
        this.takeOffFuelMoment = this.calculateFuelMoment(takeOffFuel);
        this.landingFuelMoment = this.calculateFuelMoment(landingFuel);
        this.rampFuelArm = calculateFuelArm(rampFuel, this.rampFuelMoment);
        this.takeOffFuelArm = calculateFuelArm(takeOffFuel, this.takeOffFuelMoment);
        this.landingFuelArm = calculateFuelArm(landingFuel, this.landingFuelMoment);

    }

    public double calculateFuelArm(double fuelWeight, double fuelMoment) {
        double fuelArm = (fuelMoment * 100) / fuelWeight;
        return fuelArm;
    }

    /**
     * Calculates fuel moment for any given fuel weight. Operates using the
     * lookup table generated at the bottom of the class by the constructor.
     * Works in the exact same fashion as VLOOKUP for Excel except designed by
     * me. It's quite susceptible to null pointer exceptions because it contains
     * no error handling, because the fuel loading test prevents it for
     * receiving out of range fuel
     *
     * @param fuelWeight
     * @return
     */
    public double calculateFuelMoment(double fuelWeight) {
        double moment = 0;
        ArrayList<Integer> keySetList = new ArrayList<Integer>(fuelLookup.keySet());
        int index = 0;
        while (fuelWeight > keySetList.get(index)) {
            index++;
        }
        double lowFuel = keySetList.get(index - 1);
        double lowMoment = this.fuelLookup.get(keySetList.get(index - 1));
        double highFuel = keySetList.get(index);
        double highMoment = this.fuelLookup.get(keySetList.get(index));

        moment = lowMoment + ((highMoment - lowMoment) * (fuelWeight - lowFuel) / (highFuel - lowFuel));
        return moment;
    }

    public double getRampFuelMoment() {
        return rampFuelMoment;
    }

    public void setRampFuelMoment(double rampFuelMoment) {
        this.rampFuelMoment = rampFuelMoment;
    }

    public double getRempFuelArm() {
        return rampFuelArm;
    }

    public void setRempFuelArm(double rempFuelArm) {
        this.rampFuelArm = rempFuelArm;
    }

    public double getTakeOffFuelMoment() {
        return takeOffFuelMoment;
    }

    public void setTakeOffFuelMoment(double takeOffFuelMoment) {
        this.takeOffFuelMoment = takeOffFuelMoment;
    }

    public double getTakeOffFuelArm() {
        return takeOffFuelArm;
    }

    public void setTakeOffFuelArm(double takeOffFuelArm) {
        this.takeOffFuelArm = takeOffFuelArm;
    }

    public double getLandingFuelMoment() {
        return landingFuelMoment;
    }

    public void setLandingFuelMoment(double landingFuelMoment) {
        this.landingFuelMoment = landingFuelMoment;
    }

    public double getLandingFuelArm() {
        return landingFuelArm;
    }

    public void setLandingFuelArm(double landingFuelArm) {
        this.landingFuelArm = landingFuelArm;
    }

    public LinkedHashMap<Integer, Integer> getFuelLookup() {
        return fuelLookup;
    }

    public void setFuelLookup(LinkedHashMap<Integer, Integer> fuelLookup) {
        this.fuelLookup = fuelLookup;
    }

    public LinkedHashMap<Integer, Integer> generateFuelLookup() {
        LinkedHashMap<Integer, Integer> fuelLookup = new LinkedHashMap<Integer, Integer>();
        fuelLookup.put(0, 0);
        fuelLookup.put(67, 122);
        fuelLookup.put(134, 245);
        fuelLookup.put(201, 369);
        fuelLookup.put(268, 493);
        fuelLookup.put(335, 618);
        fuelLookup.put(402, 743);
        fuelLookup.put(469, 877);
        fuelLookup.put(536, 1012);
        fuelLookup.put(603, 1148);
        fuelLookup.put(670, 1285);
        fuelLookup.put(737, 1420);
        fuelLookup.put(804, 1556);
        fuelLookup.put(871, 1692);
        fuelLookup.put(938, 1830);
        fuelLookup.put(1005, 1966);
        fuelLookup.put(1072, 2098);
        fuelLookup.put(1139, 2231);
        fuelLookup.put(1206, 2363);
        fuelLookup.put(1273, 2495);
        fuelLookup.put(1340, 2629);
        fuelLookup.put(1407, 2771);
        fuelLookup.put(1474, 2905);
        fuelLookup.put(1541, 3042);
        fuelLookup.put(1608, 3174);
        fuelLookup.put(1675, 3304);
        fuelLookup.put(1742, 3437);
        fuelLookup.put(1809, 3570);
        fuelLookup.put(1876, 3703);
        fuelLookup.put(1943, 3841);
        fuelLookup.put(2010, 3977);
        fuelLookup.put(2077, 4115);
        fuelLookup.put(2144, 4249);
        fuelLookup.put(2211, 4386);
        fuelLookup.put(2278, 4521);
        fuelLookup.put(2345, 4660);
        fuelLookup.put(2412, 4798);
        fuelLookup.put(2479, 4938);
        fuelLookup.put(2546, 5082);
        fuelLookup.put(2613, 5224);
        fuelLookup.put(2680, 5368);
        fuelLookup.put(2747, 5516);
        fuelLookup.put(2814, 5662);
        fuelLookup.put(2881, 5808);
        fuelLookup.put(2948, 5953);
        fuelLookup.put(3015, 6100);
        fuelLookup.put(3082, 6248);
        fuelLookup.put(3149, 6392);
        fuelLookup.put(3216, 6541);
        fuelLookup.put(3283, 6692);
        fuelLookup.put(3350, 6837);
        fuelLookup.put(3417, 6985);
        fuelLookup.put(3484, 7128);
        fuelLookup.put(3551, 7268);
        fuelLookup.put(3611, 7414);
        return fuelLookup;
    }
}
