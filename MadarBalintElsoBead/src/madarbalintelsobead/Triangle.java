package madarbalintelsobead;

/**
 *
 * @author Madár Bálint
 */
public class Triangle extends GeometricShape {

    public Triangle(int middle_x, int middle_y, int length_radius) {
        super(middle_x, middle_y, length_radius);
    }

    @Override
    public String toString() {
        return "Szabályos háromszög középpontja: (" + middle_y + "," + middle_y + ") Oldahossza: " + length_radius;
    }
    
            /*
    Egy adott háromszög középpontja és sugara length_radius
    
    Legkisebb x és legnagyobb x megkapása:
    Legkisebb x = középpont x koordinátája - hossz/2
    Legnagyobb x = középpont x koordinátája + hossz/2
    
    //Y megadásához Pitagorasz tételét használtam
    //Itt a magasságra van szükség a legnagyobb y koordiánta megadásához
    // az  legkisebb y koordináta a középpont + a magasság fele
    // az legnagyobb y pedig minimum y+magasság
    //A legkisebb meg  a legnagyobb inverze
     Legkisebb y és legnagyobb y megkapása:
    Legkisebb y = középpont y koordinátája - hossz
    Legnagyobb y = középpont y koordinátája - hossz
    
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
        //p tétet:
        //length
        double half = (double)length_radius/(double)2;
        double triangle_height = ((double)length_radius*(double)length_radius)-(half*half);
        return y_min= (double)middle_y-(double)triangle_height/2.0;
    }

    @Override
    public double getY_max() {
        double half = (double)length_radius/(double)2;
        double triangle_height = ((double)length_radius*(double)length_radius)-(half*half);
        return y_max = (double)y_min + (double)triangle_height;
    }

}
