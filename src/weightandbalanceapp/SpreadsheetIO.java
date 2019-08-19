package weightandbalanceapp;

import fuel.Fuel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import seating.Seat;
import storagelocations.AdditionalLoad;
import weightandbalanceapp.Aircraft;

public class SpreadsheetIO {

    private Aircraft aircraft;
    private ArrayList<String[]> ssPassengerCellsList;
    private ArrayList<String[]> ssAdditionalLoadCabinetCellsList;
    private ArrayList<String[]> ssAdditionalLoadCellsList;
    private OPCPackage pkg;
    private XSSFWorkbook wb;
    private Sheet sheet1;
    private DataFormatter formatter;

    public SpreadsheetIO(Aircraft aircraft) {
        this.aircraft = aircraft;
        this.ssPassengerCellsList = new ArrayList<String[]>();
        this.ssAdditionalLoadCabinetCellsList = new ArrayList<String[]>();
        this.ssAdditionalLoadCellsList = new ArrayList<String[]>();
        this.generateSsPassengerCellsList();
        this.geenerateSsAdditionalLoadCabinetCellsListToSS();
        this.openSpreadsheet("1.xlsx");
        System.out.println("spreadsheet opened");
        this.writeAircraftNumbertoSS();
        this.writeFuelCellstoSS();
        this.writeSsPassengerCellsListToSs();
        this.writeSsAdditionalLoadCabinetCellsListToSS();
        this.writeSsAdditionalLoadCellsArmToSS();
        this.executeFormula();
    }

    /**
     * Takes a string reference point and returns a NUMBERIC VALUE
     * <p>
     * ApachePOI is particular about data types, you could use a single function
     * and just everything as string, but this helped to ensure I knew what I
     * was retrieving before i retrieved it so wouldn't muck up the handling
     *
     * @param cellReference
     * @return
     */
    public double readCell(String cellReference) {
        for (Row row : this.sheet1) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                if (cellRef.formatAsString().equals(cellReference)) {
                    return cell.getNumericCellValue();
                }
            }
        }
        return 0;
    }

    /**
     * Takes a string reference point and returns a STRING VALUE
     *
     * @param cellReference
     * @return
     */
    public String readStringCell(String cellReference) {
        for (Row row : this.sheet1) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                if (cellRef.formatAsString().equals(cellReference)) {
                    return cell.getStringCellValue();
                }
            }
        }
        return "";
    }

    /**
     * Takes a string reference point and an integer to write to it, all written
     * values in the ss are integers so that's easy
     */
    public void writeCell(String cellReference, int write) {
        for (Row row : this.sheet1) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                if (cellRef.formatAsString().equals(cellReference)) {
                    cell.setCellValue(write);
                }
            }
        }
    }
    
    public void writeCellDouble(String cellReference, double write) {
        for (Row row : this.sheet1) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                if (cellRef.formatAsString().equals(cellReference)) {
                    cell.setCellValue(write);
                }
            }
        }
    }

    /**
     * Very important, runs all of the functions inside the spreadsheet to allow
     * retrieval of results
     */
    public void executeFormula() {
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
        for (Sheet sheet : wb) {
            for (Row r : sheet) {
                for (Cell c : r) {
                    if (c.getCellType() == CellType.FORMULA) {
                        evaluator.evaluateFormulaCell(c);
                    }
                }
            }
        }
    }

    /**
     * Opens the spreadsheet from a String based file name, sets a bunch of
     * different variables to what they need to be for Apache POI to handle the
     * spreadsheet correctly
     */
    public void openSpreadsheet(String fileName) {
        try {
            this.pkg = OPCPackage.open(new File(".\\ka350weightandbalance\\resources\\" + fileName));
            this.wb = new XSSFWorkbook(this.pkg);
            this.sheet1 = wb.getSheetAt(0);
            this.formatter = new DataFormatter();
        } catch (Exception e) {
            try {
                this.pkg = OPCPackage.open(new File(".\\resources\\" + fileName));
                this.wb = new XSSFWorkbook(this.pkg);
                this.sheet1 = wb.getSheetAt(0);
                this.formatter = new DataFormatter();
            } catch (Exception hello) {
                try {
                    this.pkg = OPCPackage.open(new File(fileName));
                    this.wb = new XSSFWorkbook(this.pkg);
                    this.sheet1 = wb.getSheetAt(0);
                    this.formatter = new DataFormatter();
                } catch (Exception me) {
                    System.out.println("============== Something is wrong with where the spreadsheet is located. ==============");
                    System.out.println("============== If using netbeans/eclipse, move spreadsheet from resources into project root ==============");
                }
            }

        }
    }

    /**
     * Writes aircraft number to Spreadsheet
     */
    public void writeAircraftNumbertoSS() {
        int tailNumber = this.aircraft.getAircraftNumber();
        double aircraftEmptyWeight = this.aircraft.getAircraftEmptyWeight();
        double aircraftEmptyArm  = this.aircraft.getAircraftEmptyArm();
        this.writeCell("B5", tailNumber);
        this.writeCellDouble("H5", aircraftEmptyWeight);
        this.writeCellDouble("I5", aircraftEmptyArm);
    }

    public void writeFuelCellstoSS() {
        Fuel fuel = this.aircraft.getFuel();
        this.writeCell(fuel.getRampFuelCell(), fuel.getRampFuel());
        this.writeCell(fuel.getSuttoCell(), fuel.getSutto());
        this.writeCell(fuel.getRouteFuelCell(), fuel.getRouteFuel());
    }

    /**
     * Takes the passenger and seat classes and combines 2 hard coded variables
     * from them to create a list of spreadsheet locations, along with the
     * weight of their bags. It's a bit messy and I think it should have been
     * handled by the passenger/seat/aircraft classes instead, but this works
     * too.
     */
    public void generateSsPassengerCellsList() { // fix it something with ading the two numbers when the cell names match
        int counter = 0;
        for (Seat seat : this.aircraft.getSeatArray()) {
            if (seat.isHasPassenger()) {
                if (seat.getPassenger().length == 2) {
                    String column = seat.getPassenger()[1].getSsColumn();  //generates the doubled numbder for the pilot and copilot
                    String row = Integer.toString(seat.getSsRow());
                    int totalBagWeight = seat.getPassenger()[0].getBagWeight() + seat.getPassenger()[1].getBagWeight();
                    String bagWeight = Integer.toString(totalBagWeight);
                    String[] array = {column + row, bagWeight};
                    this.ssPassengerCellsList.add(array);
                    counter++;
                }
                String column = seat.getPassenger()[0].getSsColumn();
                String row = Integer.toString(seat.getSsRow());
                String bagWeight = Integer.toString(seat.getPassenger()[0].getBagWeight());
                String[] array = {column + row, bagWeight};
                this.ssPassengerCellsList.add(array);
            }
        }
        if (counter > 0) {
            this.ssPassengerCellsList.get(1)[1] = this.ssPassengerCellsList.get(0)[1];
        }
    }

    /**
     * Writes a integer for the passenger in the correct column, and a bag
     * weight in the corresponding load column
     */
    public void writeSsPassengerCellsListToSs() {  // this needs some work becuase it will probably very easily break issues with the duplicate pilot cells not having data correctly
        if (this.ssPassengerCellsList.size() == 1) {
            for (String[] cell : this.ssPassengerCellsList) {
                this.writeCell(cell[0], 1);
                String bagCell = "F" + cell[0].substring(1);
                this.writeCell(bagCell, Integer.parseInt(cell[1]));
            }
        } else {
            for (String[] cell : this.ssPassengerCellsList) {
                this.writeCell(cell[0], 1);
                String bagCell = "F" + cell[0].substring(1);
                this.writeCell(bagCell, Integer.parseInt(cell[1]));
            }
            if (this.ssPassengerCellsList.get(0)[0].equalsIgnoreCase(this.ssPassengerCellsList.get(1)[0])) {
                this.writeCell(this.ssPassengerCellsList.get(0)[0], 2);
                this.writeCell("F8", Integer.parseInt(this.getSsPassengerCells().get(0)[1]));
            }
        }
    }

    /**
     * Below are the same principle as the other lists but simpler because they
     * are only impacting one cell
     */
    public void geenerateSsAdditionalLoadCabinetCellsListToSS() {
        for (AdditionalLoad load : this.aircraft.getAdditionalLoadArray()) {
            if (load.getWeight() != 0) {
                String[] array = {load.getCellName(), Integer.toString(load.getWeight())};
                this.ssAdditionalLoadCabinetCellsList.add(array);
            }
        }
    }

    public void writeSsAdditionalLoadCabinetCellsListToSS() {
        for (String[] cell : this.ssAdditionalLoadCabinetCellsList) {
            this.writeCell(cell[0], Integer.parseInt(cell[1]));
        }
    }

    public void writeSsAdditionalLoadCellsArmToSS() {
        for (AdditionalLoad load : this.aircraft.getAdditionalLoadArray()) {
            if (!load.isCabinet()) {
                String cellNumber = load.getCellName().substring(1);
                this.writeCell("I" + cellNumber, load.getArm());
            }
        }
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public ArrayList<String[]> getSsPassengerCells() {
        return ssPassengerCellsList;
    }

    public void setSsPassengerCells(ArrayList<String[]> ssPassengerCells) {
        this.ssPassengerCellsList = ssPassengerCells;
    }

    public ArrayList<String[]> getSsPassengerCellsList() {
        return ssPassengerCellsList;
    }

    public void setSsPassengerCellsList(ArrayList<String[]> ssPassengerCellsList) {
        this.ssPassengerCellsList = ssPassengerCellsList;
    }

    public ArrayList<String[]> getSsAdditionalLoadCabinetCellsList() {
        return ssAdditionalLoadCabinetCellsList;
    }

    public void setSsAdditionalLoadCabinetCellsList(ArrayList<String[]> ssAdditionalLoadCabinetCellsList) {
        this.ssAdditionalLoadCabinetCellsList = ssAdditionalLoadCabinetCellsList;
    }

    public ArrayList<String[]> getSsAdditionalLoadCellsList() {
        return ssAdditionalLoadCellsList;
    }

    public void setSsAdditionalLoadCellsList(ArrayList<String[]> ssAdditionalLoadCellsList) {
        this.ssAdditionalLoadCellsList = ssAdditionalLoadCellsList;
    }

    public OPCPackage getPkg() {
        return pkg;
    }

    public void setPkg(OPCPackage pkg) {
        this.pkg = pkg;
    }

    public XSSFWorkbook getWb() {
        return wb;
    }

    public void setWb(XSSFWorkbook wb) {
        this.wb = wb;
    }

    public Sheet getSheet1() {
        return sheet1;
    }

    public void setSheet1(Sheet sheet1) {
        this.sheet1 = sheet1;
    }

    public DataFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DataFormatter formatter) {
        this.formatter = formatter;
    }
}
