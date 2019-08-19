==============Readme==============

If you want to use Netbeans or Eclipse, you will need to drag/drop the src and resource folders
into the Eclipse/Netbeans project location.

The library files are now located in the root. Included only the .jars as all of the docs
create pointless sync issues. Ensure you add the library to the project, otherwise you
will get a lot of errors. Right click on project, libraries => add jar => and selecting all of 
them should do the trick under any IDE.

The spreadsheet file is located in /resources. If there is an issue with the setup,
it will check in the project root/default location for interacting with Java files.
It tells you if something and what is wrong, check the console or output file for
log information and move the spreadsheet location accordingly.

I am currently operating straight from master, no need for branches yet unless we start
collaborating.

1.xlsx              Current Spreadsheet
1 - MASTER.xlsx     Original Spreadsheet
output.txt          Test Results File

==============Changelog==============

1.	Removed the original comparison methodology. It was reaching deep into the aircraft and spreadsheet classes and
    wasn’t using very good OO structure.
2.	Added an AircraftCard and SpreadsheetCard classes. These are stand alone classes taking and aircraft object, 
    which have various Booleans and variables that reflect the values store in the spreadsheet and aircraft classes. Rather than having to     go hunting for these values each time they are required, the values are now stored in these classes, making the comparison
    process far simpler.
3.	At completion of the two card classes, a new comparison methodology was written. Seeing each class is the same, the
    comparison is now just comparing the respective values of each class. Far easier to understand, fault find, and
    adapt for other spreadsheets now.
4.	The Card classes could be significantly refactored. They are mirrors of each other and could be abstracted, and the
    comparison methodology changed to use loops. Once the team have an understanding on what I changed and why, I will
    implement this change.
5.  Issue found with spreadsheet FuelLookup table. "737" was duplicated. Was causing erroneous readings very
    occasionally
