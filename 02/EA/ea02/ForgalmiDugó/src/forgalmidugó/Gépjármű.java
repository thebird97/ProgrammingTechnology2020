package forgalmidug�;

public abstract class G�pj�rm� {
    
    protected final double fogyaszt�s;
    protected final String j�rm�n�v;
    protected double �zemanyagszint;
    
    public G�pj�rm�(String j�rm�n�v, double fogyaszt�s, double �zemanyagszint) {
        this.j�rm�n�v = j�rm�n�v;
        this.fogyaszt�s = fogyaszt�s;
        this.�zemanyagszint = �zemanyagszint;
    }
    
    protected abstract String j�rm�t�pus();
    protected abstract long id�intervallum();
            
    public double fogyaszt�s() {
        return this.fogyaszt�s;
    }
    
    public double �zemanyagszint() {
        return this.�zemanyagszint;
    }
    
    public void start() {
        new Thread(
                () -> {
                    boolean lefulladt = false;
                    while(!lefulladt){
                        HelyzetJelent�s jelent�s = new HelyzetJelent�s(j�rm�t�pus(), j�rm�n�v, �zemanyagszint);
                        Forgalom.p�ld�ny().helyzetjelent�stK�ld(jelent�s);
                        lefulladt = �zemanyagszint < 0.0;
                        �zemanyagszint -= fogyaszt�s;
                        try {
                            Thread.sleep(id�intervallum());
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            ).start();
    }
    
    
}
