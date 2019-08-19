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
public class CogValues {

    private double mincog;
    private double cog;
    private double maxcog;
    private double mac;
    private double range;

    public CogValues(double weight, double arm, double moment) {
        if (weight < 11800) {
            this.mincog = 191.4;
        } else {
            this.mincog = 191.4 + (weight - 11800) * 8 / 3200;
        }
        this.cog = arm;
        this.maxcog = 208;
        this.mac = (this.cog - 186.01) * 100 / 69.43;
        this.range = ((this.cog - this.mincog) / (this.maxcog - this.mincog));
    }

    public String toString() {
        return "Min COG: " + this.mincog + " COG: " + this.cog + " %MAC: " + this.mac + " Range: " + this.range + "%" + " Max COG: " + this.maxcog;
    }

    public double getMincog() {
        return mincog;
    }

    public void setMincog(double mincog) {
        this.mincog = mincog;
    }

    public double getCog() {
        return cog;
    }

    public void setCog(double cog) {
        this.cog = cog;
    }

    public double getMaxcog() {
        return maxcog;
    }

    public void setMaxcog(double maxcog) {
        this.maxcog = maxcog;
    }

    public double getMac() {
        return mac;
    }

    public void setMac(double mac) {
        this.mac = mac;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

}
