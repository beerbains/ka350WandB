/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storagelocations;

/**
 *
 * Contains the necessary variable used by the additional load class. Aircraft
 * class is responsible for initial creation of the fixed additional load slots.
 * Any subsequent slots will be created by the user, using the additional load
 * constructor
 *
 */
public class AdditionalLoad {

    private String locationName;
    public int weight;
    private int arm;
    private String cellName;
    private boolean isCabinet;

    public AdditionalLoad(String locationName, int weight, int arm, String cellName, boolean isCabinet) {
        this.locationName = locationName;
        this.weight = weight;
        this.arm = arm;
        this.cellName = cellName;
        this.isCabinet = isCabinet;
    }

    public double calculateLoadMoment() {
        double totalWeight = this.getWeight();
        double loadMoment = totalWeight * this.getArm() / 100;
        return loadMoment;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public boolean isCabinet() {
        return isCabinet;
    }

    public void setIsCabinet(boolean isCabinet) {
        this.isCabinet = isCabinet;
    }

}
