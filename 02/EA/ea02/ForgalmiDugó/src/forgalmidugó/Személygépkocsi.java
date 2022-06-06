package forgalmidugó;

public class Személygépkocsi extends Gépjármû{
    private static final String TÍPUSNÉV = "személygépkocsi";
    private static final long IDÕINTERVALLUM = 1000;

    public Személygépkocsi(String jármûnév, double fogyasztás, double üzemanyagszint) {
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
