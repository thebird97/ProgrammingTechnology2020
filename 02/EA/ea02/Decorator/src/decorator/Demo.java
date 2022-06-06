package decorator;

public class Demo {
    
    public static void main(String[] args) {
        Person johnDoe = new Person("John Doe");
        LivingRoom johnsLivingRoom = new LivingRoom(johnDoe);
        
        drawRoom(johnsLivingRoom);
        
        DooredRoomDecorator johnsLivingRoomWithDoor = 
                new DooredRoomDecorator(johnsLivingRoom, new Door(150, 210));
        drawRoom(johnsLivingRoomWithDoor);
        
        WindowedRoomDecorator johnsLivingRoomWithWindow = 
                new WindowedRoomDecorator(johnsLivingRoom, new Window(210, 120));
        drawRoom(johnsLivingRoomWithWindow);
        
        WindowedRoomDecorator johnsLivingRoomWithDoorAndWindow = 
                new WindowedRoomDecorator(johnsLivingRoomWithDoor, new Window(210, 120));
        drawRoom(johnsLivingRoomWithDoorAndWindow);
        
        Kitchen kitchen = new Kitchen();
        drawRoom(kitchen);
        
        WindowedRoomDecorator kitchenWithWindow = 
                new WindowedRoomDecorator(kitchen, new Window(210, 120));
        drawRoom(kitchenWithWindow);
        
    }
    
    private static void drawRoom(Room room) {
        System.out.println("<room>");
        room.draw();
        System.out.println("</room>");
        System.out.println("");
    }
}
