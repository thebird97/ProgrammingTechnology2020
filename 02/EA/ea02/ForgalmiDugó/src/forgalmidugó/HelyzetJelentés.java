package forgalmidug�;

public class HelyzetJelent�s {
    private final String j�rm�t�pus;
    private final String j�rm�n�v;
    private final double �zemanyagszint;
    
    public HelyzetJelent�s(String j�rm�t�pus, String j�rm�n�v, double �zemanyagszint) {
        this.j�rm�t�pus = j�rm�t�pus;
        this.j�rm�n�v = j�rm�n�v;
        this.�zemanyagszint = �zemanyagszint; 
    }
    
    public String j�rm�t�pus() {
        return j�rm�t�pus;
    }

    public String j�rm�n�v() {
        return j�rm�n�v;
    }

    public double �zemanyagszint() {
        return �zemanyagszint;
    }
    
    
}
