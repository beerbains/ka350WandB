/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weight;

/**
 *
 * @author User Name
 */
public class Weight {

    private double weight;
    private double arm;
    private double moment;
    private String name;
    private CogValues cogValues;

    public Weight(double weight, double arm, double moment, String name) {
        this.weight = weight;
        this.arm = arm;
        this.moment = moment;
        this.name = name;
        if (arm == 0) {
            this.arm = this.moment * 100 / weight;
        }
        this.cogValues = new CogValues(weight, this.arm, moment);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getArm() {
        return arm;
    }

    public void setArm(double arm) {
        this.arm = arm;
    }

    public double getMoment() {
        return moment;
    }

    public void setMoment(double moment) {
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CogValues getCogValues() {
        return cogValues;
    }

    public void setCogValues(CogValues cogValues) {
        this.cogValues = cogValues;
    }

}
