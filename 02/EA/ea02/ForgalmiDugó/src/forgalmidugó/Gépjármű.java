package forgalmidugó;

public abstract class Gépjármû {
    
    protected final double fogyasztás;
    protected final String jármûnév;
    protected double üzemanyagszint;
    
    public Gépjármû(String jármûnév, double fogyasztás, double üzemanyagszint) {
        this.jármûnév = jármûnév;
        this.fogyasztás = fogyasztás;
        this.üzemanyagszint = üzemanyagszint;
    }
    
    protected abstract String jármûtípus();
    protected abstract long idõintervallum();
            
    public double fogyasztás() {
        return this.fogyasztás;
    }
    
    public double üzemanyagszint() {
        return this.üzemanyagszint;
    }
    
    public void start() {
        new Thread(
                () -> {
                    boolean lefulladt = false;
                    while(!lefulladt){
                        HelyzetJelentés jelentés = new HelyzetJelentés(jármûtípus(), jármûnév, üzemanyagszint);
                        Forgalom.példány().helyzetjelentéstKüld(jelentés);
                        lefulladt = üzemanyagszint < 0.0;
                        üzemanyagszint -= fogyasztás;
                        try {
                            Thread.sleep(idõintervallum());
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            ).start();
    }
    
    
}
