package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Employee {
    private final long badgeNumber;
    private final String firstName;
    private final String lastName;

    private final List<LogEntry> logEntries = new ArrayList<>();
    
    public Employee(long badgeNumber, String firstName, String lastName) {
        this.badgeNumber = badgeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public boolean isPresent() {
        return logEntries.get(logEntries.size() - 1).getExitTime() == null;
    }

    public long getBadgeNumber() {
        return badgeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.badgeNumber ^ (this.badgeNumber >>> 32));
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.badgeNumber != other.badgeNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "#" + badgeNumber;
    }
    
    
}
