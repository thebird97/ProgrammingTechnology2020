package madarbalintelsobead;

public class Circle extends GeometricShape {

    public Circle(int middle_x, int middle_y, int length_radius) {
        super(middle_x, middle_y, length_radius);
    }

    @Override
    public String toString() {
        return "Kör középpontja: (" + middle_x + "," + middle_y + ") Sugara: " + length_radius;
    }
    
        /*
    Egy adott kör középpontja és sugara length_radius
    Mivel a körnek sugara van ebben a feladatban ezért
    Legkisebb x és legnagyobb x megkapása:
    Legkisebb x = középpont x koordinátája - hossz
    Legnagyobb x = középpont x koordinátája + hossz
    
     Legkisebb y és legnagyobb y megkapása:
    Legkisebb y = középpont y koordinátája - hossz
    Legnagyobb y = középpont y koordinátája - hossz
    
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
        return y_min=(double)middle_y-(double)length_radius;
    }
    
    @Override
    public double getY_max() {
        return y_max=(double)middle_y+(double)length_radius;
    }

}
