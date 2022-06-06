package imagemanipulator.grayscale;

import imagemanipulator.contract.Operation;
import imagemanipulator.contract.OperationDescriptor;
import java.awt.image.BufferedImage;
import org.imgscalr.Scalr;

public class GrayscaleOperation implements Operation{

    private final OperationDescriptor descriptor;
    
    public GrayscaleOperation() {
        this.descriptor = new OperationDescriptor("grayscale", "Converts the image into grayscale.");
    }
    
    @Override
    public OperationDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public BufferedImage execute(BufferedImage image) {
        return Scalr.apply(image, Scalr.OP_GRAYSCALE);
    }
    
}
