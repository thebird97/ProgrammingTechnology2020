package decorator;

public class WindowedRoomDecorator extends RoomDecorator{
    protected Window window;

    public WindowedRoomDecorator(Room decoratedRoom, Window window) {
        super(decoratedRoom);
        this.window = window;
    }

    @Override
    public void draw() {
        this.decoratedRoom.draw();
        System.out.println("This room has a " + this.window.getWidth() +
                "x" + this.window.getHeight() + " cm window.");
    }
    
}
