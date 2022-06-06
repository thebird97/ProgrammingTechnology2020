package imagemanipulator.contract;

import java.awt.image.BufferedImage;

public interface Operation {
    OperationDescriptor getDescriptor();
    
    BufferedImage execute(BufferedImage image);
}
