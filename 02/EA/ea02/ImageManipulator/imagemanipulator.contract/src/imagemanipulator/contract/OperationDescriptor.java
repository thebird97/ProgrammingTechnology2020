package imagemanipulator.contract;


public class OperationDescriptor {
    private final String name;
    private final String description;
    
    public OperationDescriptor(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
}
