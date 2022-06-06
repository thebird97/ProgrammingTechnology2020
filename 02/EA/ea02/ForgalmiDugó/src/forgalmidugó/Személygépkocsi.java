package forgalmidug�;

public class Szem�lyg�pkocsi extends G�pj�rm�{
    private static final String T�PUSN�V = "szem�lyg�pkocsi";
    private static final long ID�INTERVALLUM = 1000;

    public Szem�lyg�pkocsi(String j�rm�n�v, double fogyaszt�s, double �zemanyagszint) {
        super(j�rm�n�v, fogyaszt�s, �zemanyagszint);
    }
    
    @Override
    public String j�rm�t�pus() {
        return T�PUSN�V;
    }

    @Override
    protected long id�intervallum() {
        return ID�INTERVALLUM;
    }
    
}
