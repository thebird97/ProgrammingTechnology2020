package madarbalintelsobead;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 *
 * @author Madár Bálint A főprogram a MadarBalintElsoBead osztályban található.
 * ArrayList<GeometricShape> az alakzatokat tartalmazó ArrayList A fájl hibáinak
 * kezelése a try-catch szerkezettel történik a főprogramban. A datas.task();
 * meghívással fut le a lényegi program a datas ami egy ReadAndTask típusú
 * változó példányosítása után.
 *
 */
public class MadarBalintElsoBead {

    public static void main(String[] args) {
        ReadAndTask datas = new ReadAndTask();
        try {
            datas.read("hexagon.txt");

        } catch (FileNotFoundException ex) {
            System.err.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            System.err.println("Invalid input!");
            System.exit(-1);
        } catch (NoSuchElementException ex) {
            System.err.println("Empty file input!");
            System.exit(-1);
        }
        datas.task();

    }

}
