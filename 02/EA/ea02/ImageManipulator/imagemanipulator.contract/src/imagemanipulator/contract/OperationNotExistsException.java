
package imagemanipulator.contract;

public class OperationNotExistsException extends Exception {
    private final String operationName;
    
    public OperationNotExistsException(String operationName) {
        this.operationName = operationName;
    }
    
    public String getOperationName() {
        return this.operationName;
    }
}
