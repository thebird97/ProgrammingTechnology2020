package demo1;

import demo1.localizer.Localizer;
import demo1.localizer.Messages;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Prints various information from a processed log file
 * 
 * @author u527532
 */
class TimeSheet {
    private LogParser logParser;
    /**
     * log contains all of the correct entries
     */
    private List<Employee> employees;
    private List<ValidationError> violations = new ArrayList<>();
    private Localizer localizer;
    
    public TimeSheet(LogParser logParser, Localizer localizer) throws FileNotFoundException {
        this.logParser = logParser;
        this.localizer = localizer;
        employees = logParser.parse();
        violations.addAll(logParser.getViolations());
    }

    /**
     * Prints the employees that are still present
     */
    public void printWhoIsPresent() {
        for(Employee emp : employees) {
            if(emp.isPresent()) {
                System.out.println(emp);
            }
        }
    }

    /**
     * Prints the employees who arrived twice without leaving
     */
    public void printArrivalDiscrepancies() {
//        violations.stream()
//                .filter((ValidationError t) -> t.getType() == ValidationError.ViolationType.REENTRY)
//                .forEach(e -> {
//                    System.out.println(e.getEmployee());
//                });
        printEmployeesForViolationType(ValidationError.ViolationType.REENTRY);
    }

    /**
     * Prints the employees who arrived a second time earlier than a previous exit time
     */
    public void printExitDiscrepancies() {
//        violations.stream()
//                .filter((ValidationError t) -> t.getType() == ValidationError.ViolationType.SYSTEM)
//                .forEach(e -> {
//                    System.out.println(e.getEmployee());
//                });
        printEmployeesForViolationType(ValidationError.ViolationType.SYSTEM);
    }

    /**
     * Prints the number of employees who has invalid lines in the log file
     */
    public void printFaultyEmployees() {
        System.out.println(localizer.getString(Messages.INVALID_LINES, violations.size()));
    }

    private void printEmployeesForViolationType(ValidationError.ViolationType violationType) {
        for(ValidationError ve : violations) {
            if(ve.getType() == violationType) {
                System.out.println(ve.getEmployee());
            }
        }
    }

}
