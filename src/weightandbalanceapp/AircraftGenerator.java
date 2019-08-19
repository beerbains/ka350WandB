package weightandbalanceapp;

import java.util.Random;

/*This class generates:
 * Random aircraft weight between 8000 and 12000 (1dp)
 * Random aircraft moment between 100 and 250 (1dp)
 * Random aircraft tail number between 2350 and 2356 
 */

public class AircraftGenerator {
	private static int aircraftTailNum;
	private static double basicWeight;
	private static double moment;
	private static final int TAILNUMMIN = 2350;
	private static final int TAILNUMMAX = 2356;
	private static final int BASICWEIGHTMIN = 8000;
	private static final int BASICWEIGHTMAX = 12000;
	private static final int MOMENTTMIN = 100;
	private static final int MOMENTTMAX = 250;
	
	
	private static void generateAircraft() {
		Random random = new Random();
		aircraftTailNum = random.nextInt(TAILNUMMAX - TAILNUMMIN + 1) + TAILNUMMIN;
		
		int decimalWeight = random.nextInt(9-0+1)+0;// generates a random number between 0 and 9
		int intWEight = random.nextInt(BASICWEIGHTMAX-BASICWEIGHTMIN+1)+BASICWEIGHTMIN; //random number between max, min
		String basicWeightString = Integer.toString(intWEight)+"."+Integer.toString(decimalWeight);
		basicWeight = Double.parseDouble(basicWeightString);
		

		int decimalMoment = random.nextInt(9-0+1)+0;// generates a random number between 0 and 9
		int intMoment = random.nextInt(MOMENTTMAX-MOMENTTMIN+1)+MOMENTTMIN; //random number between max, min
		String momentString = Integer.toString(intMoment)+"."+Integer.toString(decimalMoment);
		moment = Double.parseDouble(momentString);
	}
	
	
	/**
	 * @return the aircraftTailNum
	 */
	public static int getAircraftTailNum() {
		generateAircraft();
		System.out.println("aicraft tail number: "+aircraftTailNum);
		return aircraftTailNum;
	}
	
	/**
	 * @return the basicWeight
	 */
	public static double getBasicWeight() {
		generateAircraft();
		System.out.println("aicraft basic weight: "+ basicWeight);
		return basicWeight;
	}
	
	/**
	 * @return the moment
	 */
	public static double getMoment() {
		generateAircraft();
		System.out.println("aircraft moment: "+moment);
		return moment;
	}	

}
