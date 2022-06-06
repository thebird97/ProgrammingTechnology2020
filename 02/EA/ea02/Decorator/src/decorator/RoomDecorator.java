package decorator;

public abstract class RoomDecorator implements Room {
    protected Room decoratedRoom;
    
    public RoomDecorator(Room decoratedRoom) {
        this.decoratedRoom = decoratedRoom;
    }

    @Override
    public abstract void draw();
}
