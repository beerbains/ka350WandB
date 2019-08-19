/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontypes;

/**
 * Generic man class. Contains weight attributes and bag weight attributes which
 * will be used to calculate moment
 */
public class Man extends Person {

    public Man(String name, int bagWeight) {
        super(name, bagWeight, 190, true, true, "B");
    }

    public String toString() {
        return "Man";
    }
}
