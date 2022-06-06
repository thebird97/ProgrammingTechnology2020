package imagemanipulator.app;

import imagemanipulator.antialias.AntialiasOperation;
import imagemanipulator.backend.ImageManipulatorServiceImpl;
import imagemanipulator.contract.ImageManipulatorService;
import imagemanipulator.contract.ImageManipulatorUI;
import imagemanipulator.contract.Operation;
import imagemanipulator.contract.OperationDescriptor;
import imagemanipulator.contract.OperationNotExistsException;
import imagemanipulator.frontend.FakeUI;
import imagemanipulator.frontend.ImageManipulatorUIImpl;
import imagemanipulator.grayscale.GrayscaleOperation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.imageio.ImageIO;
import static org.easymock.EasyMock.*;

public class Main {
   
    private static ImageManipulatorService createMockService() throws IOException, OperationNotExistsException {
        BufferedImage image1 = ImageIO.read(new File("D:\\progtech\\mock1.jpg"));
        BufferedImage image2 = ImageIO.read(new File("D:\\progtech\\mock2.jpg"));
        
        Collection<OperationDescriptor> mockOperationDescriptors = new ArrayList<>();
        OperationDescriptor mockOperation1Descr = new OperationDescriptor("mock1", "mock1descr");
        OperationDescriptor mockOperation2Descr = new OperationDescriptor("mock2", "mock2descr");
        mockOperationDescriptors.add(mockOperation1Descr);
        mockOperationDescriptors.add(mockOperation2Descr);
        
        ImageManipulatorService service = mock(ImageManipulatorService.class);
        expect(service.getOperationDescriptors()).andStubReturn(mockOperationDescriptors);
        expect(service.executeImageManipulatingOperation("mock1", null)).andStubReturn(null);
        expect(service.executeImageManipulatingOperation(eq("mock1"), notNull())).andStubReturn(image1);
        expect(service.executeImageManipulatingOperation("mock2", null)).andStubReturn(null);
        expect(service.executeImageManipulatingOperation(eq("mock2"), notNull())).andStubReturn(image2);
        replay(service);
        
        return service;
    }
    
    private static ImageManipulatorService createRealService() {
        ImageManipulatorServiceImpl service = new ImageManipulatorServiceImpl();
        service.addOperation(new AntialiasOperation());
        service.addOperation(new GrayscaleOperation());
        
        return service;
    }
    public static void main(String[] args) throws IOException, OperationNotExistsException {
        
        //ImageManipulatorService service = createMockService();
        ImageManipulatorService service = createRealService();
        ImageManipulatorUI ui = new ImageManipulatorUIImpl(service);
        ui.run();
    }
  
}
