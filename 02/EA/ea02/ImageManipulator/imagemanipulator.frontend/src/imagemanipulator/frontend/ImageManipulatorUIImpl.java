
package imagemanipulator.frontend;

import imagemanipulator.contract.ImageManipulatorService;
import imagemanipulator.contract.OperationDescriptor;
import imagemanipulator.contract.OperationNotExistsException;
import imagemanipulator.contract.ImageManipulatorUI;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ImageManipulatorUIImpl implements ImageManipulatorUI {
    private final ImageManipulatorService service;
    
    public ImageManipulatorUIImpl(ImageManipulatorService service) {
        this.service = service;
    }
    
    public void run() {
        Scanner console = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.println("Do you want to manipulate an image? (0 - No, 1 - Yes) ");
            choice = console.nextInt();
            
            if(choice == 0) {
                break;
            } else {
                mainMenu();
                System.out.println("------------");
            }
        }
        
    }

    private void mainMenu() {
        System.out.println("Path: ");
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        try {
            BufferedImage image = readImageFromPath(path);
            processImage(console, image);
            
        } catch (IOException ex) {
            System.err.println("Cannot read file.");
        } 
    }

    private void processImage(Scanner console, BufferedImage image) {
        while(true) {
            System.out.println("Available operations: ");
            printOperationDescriptions();
            System.out.println("Your choice (name): ");
            String name = console.nextLine();
            try{
                BufferedImage processedImage = service.executeImageManipulatingOperation(name, image);
                save(processedImage);
                return;
            } catch(OperationNotExistsException e) {
                System.err.println("There's no operation with this name.");
            }
        }
    }

    private void printOperationDescriptions() {
        for(OperationDescriptor descriptor : service.getOperationDescriptors() ){
            System.out.println(descriptor.getName() + ";\tDescription: " + descriptor.getDescription());
        }
    }
    
    private BufferedImage readImageFromPath(String path) throws IOException {
        return ImageIO.read(new File(path));
    }

    private void save(BufferedImage processedImage) {
        while(true) {
            System.out.println("Path to save: ");
            Scanner console = new Scanner(System.in);
            String path = console.nextLine();
            File file = new File(path);
            try {
                String extension = path.substring(path.lastIndexOf(".")+1);
                ImageIO.write(processedImage, extension, file);
                System.out.println("Save successful");
                return;
            } catch (IOException ex) {
                System.out.println("Cannot save image.");
            }
        }
    }

  

   
}
