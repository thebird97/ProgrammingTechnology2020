package madarbalintelsobead;
import java.lang.Math; 
/**
 *
 * @author Madár Bálint
 */
public class Hexagon extends GeometricShape {

    public Hexagon(int middle_x, int middle_y, int length_radius) {
        super(middle_x, middle_y, length_radius);
    }

    @Override
    public String toString() {
        return "Hatszög középpontja: (" + middle_x + "," + middle_y + ") Oldahossza: " + length_radius;
    }
    
            /*
    Egy adott hexagon(hatszög) 
    Mivel a hatszög oldalainak hosssza megegyezik a köré írható kör sugarával 
    ezért
    Legkisebb x és legnagyobb x megkapása:
    Legkisebb x = középpont x koordinátája - hossz
    Legnagyobb x = középpont x koordinátája + hossz
    
     Legkisebb y és legnagyobb y megkapása:
    y_max: ri = kp + a/2*srt(3) 
    y_min: ri = kp - a/2*srt(3)
    
    */
    @Override
     public double getX_min() {
        return x_min=(double)middle_x-(double)length_radius;
    }
     
    @Override
    public double getX_max() {
        return x_max=(double)middle_x+(double)length_radius;
    }
    
    @Override
    public double getY_min() {
        //ri = kp - a/2*srt(3) 
        return y_min=(double)middle_y-(Math.sqrt(3)*(double)length_radius/2.0);
          
           
    }
    
    @Override
    public double getY_max() {
         ///beírható kör sugara alapján //ri y_max
         //ri = kp + a/2*srt(3) 
        return y_max=(double)middle_y+(Math.sqrt(3)*(double)length_radius/2.0);
        
    }
    
    
}
