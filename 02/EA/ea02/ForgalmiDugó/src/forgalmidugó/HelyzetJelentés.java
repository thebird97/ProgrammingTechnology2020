package forgalmidugó;

public class HelyzetJelentés {
    private final String jármûtípus;
    private final String jármûnév;
    private final double üzemanyagszint;
    
    public HelyzetJelentés(String jármûtípus, String jármûnév, double üzemanyagszint) {
        this.jármûtípus = jármûtípus;
        this.jármûnév = jármûnév;
        this.üzemanyagszint = üzemanyagszint; 
    }
    
    public String jármûtípus() {
        return jármûtípus;
    }

    public String jármûnév() {
        return jármûnév;
    }

    public double üzemanyagszint() {
        return üzemanyagszint;
    }
    
    
}
