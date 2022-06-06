package decorator;


public class DooredRoomDecorator extends RoomDecorator{
    protected Door door;

    public DooredRoomDecorator(Room decoratedRoom, Door door) {
        super(decoratedRoom);
        this.door = door;
    }

    @Override
    public void draw() {
        this.decoratedRoom.draw();
        System.out.println("This room has a " + this.door.getWidth() +
                "x" + this.door.getHeight() + " cm door.");
    }
}
