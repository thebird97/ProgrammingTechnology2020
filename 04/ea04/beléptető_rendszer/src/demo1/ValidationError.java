package demo1;

class ValidationError {

    enum ViolationType {
        SYSTEM, REENTRY
    }
    
    private final ViolationType type;
    private final Employee emplosee;

    public ValidationError(ViolationType type, Employee employee) {
        this.type = type;
        this.emplosee = employee;
    }

    public ViolationType getType() {
        return type;
    }

    public Employee getEmployee() {
        return emplosee;
    }
}
