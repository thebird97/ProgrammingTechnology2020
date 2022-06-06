
package imagemanipulator.antialias;


import imagemanipulator.contract.Operation;
import imagemanipulator.contract.OperationDescriptor;
import java.awt.image.BufferedImage;
import org.imgscalr.Scalr;

public class AntialiasOperation implements Operation{

    private final OperationDescriptor descriptor;
    
    public AntialiasOperation() {
        this.descriptor = new OperationDescriptor("antialias", "Softens the image a bit (acts like"
                + "an antialias filter.");
    }
    
    @Override
    public OperationDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public BufferedImage execute(BufferedImage image) {
        return Scalr.apply(image, Scalr.OP_ANTIALIAS);
    }
    
}

