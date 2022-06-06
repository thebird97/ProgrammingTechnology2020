package forgalmidugó;


public class Kisbusz extends Gépjármû{
    private static final String TÍPUSNÉV = "kisbusz";
    private static final long IDÕINTERVALLUM = 2000;
    
    public Kisbusz(String jármûnév, double fogyasztás, double üzemanyagszint) {
        super(jármûnév, fogyasztás, üzemanyagszint);
    }
    
    @Override
    public String jármûtípus() {
        return TÍPUSNÉV;
    }
    
    @Override
    protected long idõintervallum() {
        return IDÕINTERVALLUM;
    }
}
