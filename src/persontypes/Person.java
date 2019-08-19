/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontypes;

/**
 * Abstract class to contain all of the different types of people.
 */
public abstract class Person {

    private String name;
    private int bagWeight;
    private int weight;
    private boolean canCockpit;
    private boolean canToilet;
    private String ssColumn;

    public Person(String name, int bagWeight, int weight, boolean canCockpit, boolean canToilet, String ssColumn) {
        this.name = name;
        this.bagWeight = bagWeight;
        this.weight = weight;
        this.canCockpit = canCockpit;
        this.canToilet = canToilet;
        this.ssColumn = ssColumn;
    }

    public boolean canToilet() {
        return this.canToilet;
    }

    public boolean canCockpit() {
        return this.canCockpit;
    }

    public double getTotalWeight() {
        double total = bagWeight + weight;
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(int bagWeight) {
        this.bagWeight = bagWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCanCockpit(boolean canCockpit) {
        this.canCockpit = canCockpit;
    }

    public void setCanToilet(boolean canToilet) {
        this.canToilet = canToilet;
    }

    public String getSsColumn() {
        return ssColumn;
    }

    public void setSsColumn(String ssColumn) {
        this.ssColumn = ssColumn;
    }
    
    

}
