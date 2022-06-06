package madarbalintelsobead;

/**
 *
 * @author Madár Bálint
 */
public class Square extends GeometricShape {

    public Square(int middle_x, int middle_y, int length_radius) {
        super(middle_x, middle_y, length_radius);
    }
    
    @Override
    public String toString() {
        return "Négyzet középpontja: (" + middle_y + "," + middle_y + ") Oldahossza: " + length_radius;
    }
    
    /*
    Egy adott négyzet középpontja és oldalhossza length_radius
    Legkisebb x és legnagyobb x megkapása:
    Legkisebb x = középpont x koordinátája - hossz/2
    Legnagyobb x = középpont x koordinátája + hossz/2
    
     Legkisebb y és legnagyobb y megkapása:
    Legkisebb y = középpont y koordinátája - hossz/2
    Legnagyobb y = középpont y koordinátája - hossz/2
    
    */
    @Override
     public double getX_min() {
        return x_min=(double)middle_x-((double)length_radius/(double)2);
    }
     
    @Override
    public double getX_max() {
        return x_max=(double)middle_x+((double)length_radius/(double)2);
    }
    
    @Override
    public double getY_min() {
        return y_min=(double)middle_y-((double)length_radius/(double)2);
    }
    
    @Override
    public double getY_max() {
        return y_max=(double)middle_y+((double)length_radius/(double)2);
    }
}
