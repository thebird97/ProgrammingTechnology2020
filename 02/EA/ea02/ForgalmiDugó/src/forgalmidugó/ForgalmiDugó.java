package forgalmidugó;

public class ForgalmiDugó {

    public static void main(String[] args) {
        new Személygépkocsi("gk1", 12.0, 73.4).start();
        new Személygépkocsi("gk2", 12.0, 120.9).start();
        new Kisbusz("kb1", 120.0, 730.4).start();
        new Kisbusz("kb2", 120.0, 1200.923).start();
    }
    
}
