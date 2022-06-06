package madarbalintelsobead;

public abstract class GeometricShape {

    public int middle_x;
    public int middle_y;
    public int length_radius;
   
    public double x_min;
    public double x_max;
    public double y_min;
    public double y_max;
    
    public GeometricShape(int middle_x, int middle_y, int length_radius) {
        this.middle_x = middle_x;
        this.middle_y = middle_y;
        this.length_radius = length_radius;
    }

    public int getMiddle_x() {
        return middle_x;
    }

    public int getMiddle_y() {
        return middle_y;
    }

    public int getLength_radius() {
        return length_radius;
    }

    public void setMiddle_x(int middle_x) {
        this.middle_x = middle_x;
    }

    public void setMiddle_y(int middle_y) {
        this.middle_y = middle_y;
    }

    public void setLength_radius(int length_radius) {
        this.length_radius = length_radius;
    }
    
        public double getX_min() {
        return x_min;
    }

    public double getX_max() {
        return x_max;
    }

    public double getY_min() {
        return y_min;
    }

    public double getY_max() {
        return y_max;
    }

}
