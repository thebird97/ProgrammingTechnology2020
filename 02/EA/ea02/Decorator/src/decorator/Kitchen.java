package decorator;


public class Kitchen implements Room{

    @Override
    public void draw() {
        System.out.println("This is a kitchen.");
    }
    
}
