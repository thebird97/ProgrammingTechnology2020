
package imagemanipulator.frontend;

import imagemanipulator.contract.ImageManipulatorService;
import imagemanipulator.contract.ImageManipulatorUI;
import imagemanipulator.contract.OperationDescriptor;

public class FakeUI implements ImageManipulatorUI {

    private final ImageManipulatorService service;
    public FakeUI(ImageManipulatorService service) {
        this.service = service;
    }
    
    @Override
    public void run() {
        for(OperationDescriptor descriptor: service.getOperationDescriptors()) {
            System.out.println(descriptor.getName() + "; " + descriptor.getDescription());
        }
    }
    
}
