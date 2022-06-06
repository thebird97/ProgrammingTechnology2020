package decorator;

public class LivingRoom implements Room{

    private final Person owner;
    public LivingRoom(Person owner) {
        this.owner = owner;
    }
    
    @Override
    public void draw() {
        System.out.println(owner.getName() + "'s living room.");
    }
    
}
