/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontypes;

/**
 * Generic infant class. Contains weight attributes and bag weight attributes
 * which will be used to calculate moment
 */
public class Infant extends Person {

    public Infant(String name, int bagWeight) {
        super(name, bagWeight, 34, false, false, "E");
    }
    
        public String toString() {
        return "Infant";
    }
}
