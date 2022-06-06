package demo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class LogParser {
    private File logFile;
    private List<ValidationError> violations = new ArrayList<>();

    public LogParser(String filePath) {
        logFile = new File(filePath);
    }

    /*
     * use checked exceptions for conditions from which the caller can reasonably 
     * be expected to recover. By throwing a checked exception, you force the 
     * caller to handle the exception in a catch clause or to propagate it outward. 
     */
    
    /**
     * Process the logfile line by line
     * 
     * @return 
     * @throws FileNotFoundException 
     */
    public List<Employee> parse() throws FileNotFoundException {
        List<Employee> result = new ArrayList<>();
        try(Scanner sc = new Scanner(logFile)) {
            while(sc.hasNextLine()) {
                processLine(sc.nextLine(), result);
            }
            return result;
        }
    }

    /**
     * Process a line, the line should have the following format:
     * 
     *      {badgeNR}   {arrivel time} {firstname} {lastname} {leave time}
     *      11111111    08:40           Pista       bácsi       09:00
     * 
     * @param line
     * @param result 
     */
    private void processLine(String line, List<Employee> result)  {
        Pattern timePattern = Pattern.compile("\\d{2}:\\d{2}");
        Pattern stringPattern = Pattern.compile("\\D*");
        Scanner sc = new Scanner(line);
        long badgeNr = sc.nextLong();
        String entryTime = sc.next(timePattern);
        String firstName = sc.next(stringPattern);
        String lastName = sc.next(stringPattern);
        String exitTime = null;
        if(sc.hasNext()) {
            exitTime = sc.next(timePattern);
        }
        LocalTime eTime = exitTime == null ? null : LocalTime.parse(exitTime);
        
        Employee emp = new Employee(badgeNr, firstName, lastName);
        LogEntry entry = new LogEntry(LocalTime.parse(entryTime), eTime);
        try {
            processEntry(emp, entry, result);
        } catch (EntryValidationException ex) {
            ValidationError ve = new ValidationError(ex.getType(), ex.getEmployee());
            violations.add(ve);
        }
    }

    private void processEntry(Employee employee, LogEntry entry, List<Employee> result) throws EntryValidationException {
        if(result.contains(employee)) {
            int index = result.indexOf(employee);
            Employee savedEmployee = result.get(index);
            validateEntry(savedEmployee, entry);
            savedEmployee.getLogEntries().add(entry);
        } else {
            employee.getLogEntries().add(entry);
            result.add(employee);
        }
    }

    private void validateEntry(Employee employee, LogEntry entry) throws EntryValidationException {
        List<LogEntry> entries = employee.getLogEntries();
        LogEntry lastEntry = entries.get(entries.size() - 1);
        if(lastEntry.getExitTime() == null) {
            throw new EntryValidationException(employee, ValidationError.ViolationType.REENTRY);
        }
        for(LogEntry e : entries) {
            if(e.getExitTime() != null && e.getExitTime().isAfter(entry.getArrivalTime())) {
                throw new EntryValidationException(employee, ValidationError.ViolationType.SYSTEM);
            }
        }
    }

    public List<ValidationError> getViolations() {
        return Collections.unmodifiableList(violations);
    }

}
