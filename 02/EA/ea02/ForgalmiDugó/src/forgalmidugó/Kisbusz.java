package forgalmidug�;


public class Kisbusz extends G�pj�rm�{
    private static final String T�PUSN�V = "kisbusz";
    private static final long ID�INTERVALLUM = 2000;
    
    public Kisbusz(String j�rm�n�v, double fogyaszt�s, double �zemanyagszint) {
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
