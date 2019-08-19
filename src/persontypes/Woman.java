/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontypes;

/**
 * Generic woman class. Contains weight attributes and bag weight attributes
 * which will be used to calculate moment
 */
public class Woman extends Person {

    public Woman(String name, int bagWeight) {
        super(name, bagWeight, 175, true, true, "C");
    }
    
        public String toString() {
        return "Woman";
    }
}
