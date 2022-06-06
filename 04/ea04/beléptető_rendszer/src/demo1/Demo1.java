package demo1;

import demo1.localizer.Localizer;
import demo1.localizer.Messages;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Demo1 {

    public static void main(String[] args) {
        Localizer localizer = new Localizer("hu.txt");
        try {
            TimeSheet ts = new TimeSheet(new LogParser("log.txt"), localizer);
            
            System.out.println("1. Kik tartózkodnak még bent?");
            ts.printWhoIsPresent();
            System.out.println("=============================");
            System.out.println("2. nem távoztak látszólag, mégis újra beléptek? ");
            ts.printArrivalDiscrepancies();
            System.out.println("=============================");
            System.out.println("3. volt-e rendszerhiba?");
            ts.printExitDiscrepancies();
            System.out.println("=============================");
            System.out.println("4. hibás sorok?");
            ts.printFaultyEmployees();
        } catch (FileNotFoundException ex) {
            System.err.println(localizer.getString(Messages.FILE_NOT_FOUND));
        } catch (InputMismatchException ex) {
            System.err.println(localizer.getString(Messages.INVALID_FILE_FORMAT));
        }
    }
    
}
