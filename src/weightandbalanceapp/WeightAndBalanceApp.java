/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightandbalanceapp;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WeightAndBalanceApp {

    /**
     * Program writes to ~/output.txt, there's a catch for it that shouldn't
     * ever do anything hence why it doesn't do anything.
     * <p>
     * Currently only generates 2353 x number of times, could either random it
     * up or start a second for loop for 2351 (not required IMO, but could be
     * useful to aid your understanding of how the program works. Program then
     * resets sout to console at the end and lets the program know its complete.
     * <p>
     * Each iteration is a new aircraft being created, input controller controls
     * the aircraft (generates passengers etc), spreadsheetIO handles all of the
     * spreadsheet interfacing, compare output is responsible for all of the
     * tests between spreadsheet and program. Other than the Aircraft, the other
     * classes are functional and not really pure objects, otherwise everything
     * would be in the main method and I don't do that.
     * <p>
     * Going forward for testing other spreadsheets, the most useful code is the
     * SpreadsheetIO code. I took code from ApachePOI and modified it to handle
     * things in a way that makes sense given the data structure.
     * <p>
     * I use lots of encapsulation in my code. It often makes code hard to read
     * and looks like there are a lot of complicated calls, but its usually just
     * hitting getters setters and constructors. If something is long and hard
     * to find, right click the function/variable/whatever-> click go to source
     * is super helpful if you haven't been doing that already.
     * <p>
     * I haven't put in much error handling, so if you manually start changing
     * things in the IDE (passenger numbers, pilot numbers, too low fuel) it
     * will crash horrifically. It's designed to be used through userIO and
     * rngIO, changing things manually will break it, unless you learn what you
     * are doing. Everything is handled with arraylists, so if you keep within
     * the bounds of the arraylist it wont crash.
     * <p>
     * The FuelMoment class is quite particular about what values you give it as
     * it runs on a big has table searching for a [x - 1] position in the array.
     * Passenger loading is similar too as it runs to a fixed array size. It's
     * bad practice doing it that way but as mentioned above, its designed to
     * work one way - and it works well that way.
     * <p>
     * The 6 squadron one, you wont need to do any where near as much object
     * based programming. You could just redesign the spreadsheetIO and run it a
     * bunch of times. It still has 55 factorial (ish) different combinations
     * (this one has practically infinite with all the possible weights) so I'd
     * just use random again, but its up to you guys if you think a 55 stack of
     * for loops will give you a better result.
     * <p>
     * My variables, classes and functions are all well name so its fairly clear
     * what they do. There's a sprinkling of documentation for some things.
     * Right click, go to source is your best friend. SS stands for SpreadSheet,
     * not that other thing, I just realized that. I removed the other bad word
     * variable names, so there shouldn't be any surprises if you need to show
     * someone.
     * <p>
     * The program is currently set up to process 1.xlsx. 1.xlsx is a modified
     * version of the spreadsheet where I have removed some of the rounding
     * which was giving me differing results and fixed the %MAC values to
     * accurately reflect the AFM. 1 - MASTER.xlsx is the original file 42 SQN
     * gave me. test it and you will see how/where/why it is different. I
     * suggest 1.xlsx is the file we give them back to use. This is reflected in
     * my report.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ensure the all Spreadsheet user entry points are empty prior to running the test harness");
        System.out.println("Number of tests: ");
        int numberOfTests = 10;
        try {
            numberOfTests = input.nextInt();
        } catch (Exception e) {
            System.out.println("Not an integer, defaulting to 10");
        }
        System.out.println("Type 'c' to log to console, or 't' to log to text file");
        input.nextLine();
        String query = input.next();
        PrintStream console = System.out;
        if (!query.equalsIgnoreCase("c")) {
            try {
                System.out.println("Writing resources/output.txt...");
                PrintStream out = new PrintStream(new FileOutputStream(".\\ka350weightandbalance\\resources\\output.txt"));
                System.setOut(out);
            } catch (Exception e) {
                try {
                    PrintStream out = new PrintStream(new FileOutputStream(".\\resources\\output.txt"));
                    System.setOut(out);
                } catch (Exception other) {
                    System.out.println("Writing to resources/output.txt failed");
                    System.out.println("Folders not set-up, writing to project root");
                    try {
                        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                        System.setOut(out);
                    } catch (Exception newE) {
                    }
                }

            }
        }

        for (int i = 0; i < numberOfTests; i++) {
            Aircraft aircraft = new Aircraft(AircraftGenerator.getAircraftTailNum(), AircraftGenerator.getBasicWeight(), AircraftGenerator.getMoment());
            InputController io = new InputController(aircraft);
            AircraftCard aircraftCard = new AircraftCard(aircraft);
            SpreadsheetIO ssio = new SpreadsheetIO(aircraft);
            SpreadsheetCard ssCard = new SpreadsheetCard(ssio);
            CompareOutput compare = new CompareOutput(aircraft, ssio, aircraftCard, ssCard);
            System.out.println();
            try {
                ssio.getWb().close();
            } catch (Exception e) {
            }
        }
        System.setOut(console);
        System.out.println("Test Complete");

    }
}
