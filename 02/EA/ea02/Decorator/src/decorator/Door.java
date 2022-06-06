package decorator;

public class Door {
    protected final int width;
    protected final int height;
    
    public Door(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
}
