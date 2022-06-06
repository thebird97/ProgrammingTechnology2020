package imagemanipulator.backend;

import imagemanipulator.contract.ImageManipulatorService;
import imagemanipulator.contract.Operation;
import imagemanipulator.contract.OperationDescriptor;
import imagemanipulator.contract.OperationNotExistsException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;


public class ImageManipulatorServiceImpl implements ImageManipulatorService {

    private final Collection<OperationDescriptor> operationDescriptors;
    private final Collection<Operation> operations;
    
    public ImageManipulatorServiceImpl() {
        this(new ArrayList<>());
    }
    
    public ImageManipulatorServiceImpl(Collection<Operation> operations) {
        this.operations = operations;
        this.operationDescriptors = new ArrayList<>();
    }
    
    @Override
    public Collection<OperationDescriptor> getOperationDescriptors() {
        return this.operationDescriptors;
    }

    @Override
    public BufferedImage executeImageManipulatingOperation(String name, BufferedImage image)
        throws OperationNotExistsException{
 
        Operation operation = findOperationByName(name);
        if(operation == null) {
            throw new OperationNotExistsException(name);
        }
        return operation.execute(image);      
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
        this.operationDescriptors.add(operation.getDescriptor());
    }

    public void removeOperation(Operation operation) {
        this.operations.remove(operation);
        this.operationDescriptors.remove(operation.getDescriptor());
    }
    
    private Operation findOperationByName(String name) {
        for(Operation operation : this.operations) {
            if(name.equals(operation.getDescriptor().getName())){
                return operation;
            }
        }
        return null;
    }
    
}
