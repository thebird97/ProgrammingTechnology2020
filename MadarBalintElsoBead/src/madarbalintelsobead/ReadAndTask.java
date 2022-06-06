package madarbalintelsobead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndTask {

    private final ArrayList<GeometricShape> shapes;

    public ReadAndTask() {
        shapes = new ArrayList<>();
    }

    /*
    read()
    a fájl beolvasásáért felelő metódus scannerel
     */
    public void read(String filename) throws FileNotFoundException, InvalidInputException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int numofShapes = sc.nextInt();
        while (sc.hasNext()) {
            GeometricShape shape = null;
            switch (sc.next()) {
                case "c":
                    //shapes.add(new Circle(sc.nextInt(),sc.nextInt(),sc.nextInt()));
                    shape = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case "s":
                    shape = new Square(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case "h":
                    shape = new Hexagon(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case "t":
                    shape = new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                default:
                    throw new InvalidInputException();
            }
            shapes.add(shape);
        }

    }

    /*
     A task() metódusmeghatározza legkisebb téglalapot, amely lefedi az összes síkidomot és oldalai párhuzamosak a tengelyekkel.
       Működése: 
        0. Maximum és minimum kiválasztás tétele
        1. A legisebb x kiválasztása az adott alakzat legkisebb xei közül és
            a legnagypbb x kiválasztása az adott alakzat legkisebb xei közül
        2.  A legisebb y kiválasztása az adott alakzat legkisebb y-i közül és
            a legnagypbb y kiválasztása az adott alakzat legkisebb y-i közül
     
     
     */
    public void task() {
        for (int valt = 0; valt < shapes.size(); valt++) {
            System.out.println(shapes.get(valt));
        }

        double smallest_y = shapes.get(0).getY_min();
        double biggest_y = shapes.get(0).getY_max();

        double smallest_x = shapes.get(0).getX_min();
        double biggest_x = shapes.get(0).getX_max();
        
       
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(0).getY_min() < smallest_y) {
                smallest_y = shapes.get(0).getY_min();
            }

            if ( shapes.get(0).getY_max() > biggest_y) {
                biggest_y = shapes.get(0).getY_max();
            }

            if (shapes.get(0).getX_min() < smallest_x) {
               smallest_x = shapes.get(0).getX_min();
            }

            if (shapes.get(0).getX_max()>biggest_x) {
                biggest_x = shapes.get(0).getX_max() ;
            }

        }

        System.out.println("Minumum x az alakzat oldalhoszza koordiánta: " + smallest_x);
        System.out.println("Maximum x az alakzat oldalhosszával koordiánta: " + biggest_x);
        System.out.println("Minimum y az alakzat oldalhosszával koordiánta: " + smallest_y);
        System.out.println("Maximum y az alakzat oldalhosszával koordiánta: " + biggest_y);

        double smallest_oblong_length = (biggest_x - smallest_x);
        double smallest_oblong_height = (biggest_y - smallest_y);

        System.out.println("A lekisebb téglalap ami lefedi a síkidomot, hossza: " + smallest_oblong_length + " és magassága: " + smallest_oblong_height);
        System.out.println("A lekisebb téglalap ami lefedi a síkidomot, középpontja: (" + (biggest_x - (smallest_oblong_length / 2)) + ", " + (biggest_x - (smallest_oblong_height / 2)) + ")");
        

        double aypont = biggest_y;
        double bypoint=smallest_y;
        double cypoint=biggest_y;
        double dypoint=smallest_y;       

        
        System.out.println("A téglalap 4 pontja:");
        System.out.println("A téglalap A pontja ("  + smallest_x + "," + aypont +")");
        System.out.println("A téglalap B pontja: ("  + smallest_x + "," + bypoint +")");
        System.out.println("A téglalap C pontja: ("  + biggest_x + "," + cypoint +")");
        System.out.println("A téglalap D pontja: ("  + biggest_x + "," + dypoint +")");
    }

    public void clear() {
        shapes.clear();
    }

}
