package forgalmidug�;

public class Forgalom {
    private static Forgalom p�ld�ny;
   
    public static synchronized Forgalom p�ld�ny() {
        if (p�ld�ny == null) {
            p�ld�ny = new Forgalom();
        }
        return p�ld�ny;
    }
    
    public synchronized void helyzetjelent�stK�ld(HelyzetJelent�s jelent�s) {
        String �zemanyagszintJelz�s = jelent�s.�zemanyagszint() > 0.0
                ? Double.toString(jelent�s.�zemanyagszint())
                : "lefulladt";
        
        System.out.println(jelent�s.j�rm�n�v() + "," + jelent�s.j�rm�t�pus() + ": " +
                �zemanyagszintJelz�s);
    }
}
