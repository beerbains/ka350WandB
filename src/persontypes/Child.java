/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persontypes;

/**
 * Generic child class. Contains weight attributes and bag weight attributes
 * which will be used to calculate moment
 */
public class Child extends Person {

    public Child(String name, int bagWeight) {
        super(name, bagWeight, 70, true, false, "D");
    }
    
        public String toString() {
        return "Child";
    }
}
