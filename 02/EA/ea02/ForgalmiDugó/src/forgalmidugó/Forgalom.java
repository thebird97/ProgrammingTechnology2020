package forgalmidugó;

public class Forgalom {
    private static Forgalom példány;
   
    public static synchronized Forgalom példány() {
        if (példány == null) {
            példány = new Forgalom();
        }
        return példány;
    }
    
    public synchronized void helyzetjelentéstKüld(HelyzetJelentés jelentés) {
        String üzemanyagszintJelzés = jelentés.üzemanyagszint() > 0.0
                ? Double.toString(jelentés.üzemanyagszint())
                : "lefulladt";
        
        System.out.println(jelentés.jármûnév() + "," + jelentés.jármûtípus() + ": " +
                üzemanyagszintJelzés);
    }
}
