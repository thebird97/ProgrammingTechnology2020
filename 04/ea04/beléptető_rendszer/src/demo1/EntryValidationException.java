package demo1;

class EntryValidationException extends Exception {

    private Employee employee;
    private ValidationError.ViolationType type;

    public EntryValidationException(Employee employee, ValidationError.ViolationType type) {
        this.employee = employee;
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ValidationError.ViolationType getType() {
        return type;
    }
    
}
