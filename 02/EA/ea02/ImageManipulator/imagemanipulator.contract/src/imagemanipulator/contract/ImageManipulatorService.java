package imagemanipulator.contract;

import java.awt.image.BufferedImage;
import java.util.Collection;

public interface ImageManipulatorService {
    Collection<OperationDescriptor> getOperationDescriptors();
    BufferedImage executeImageManipulatingOperation(String name, BufferedImage image)
            throws OperationNotExistsException;
}
