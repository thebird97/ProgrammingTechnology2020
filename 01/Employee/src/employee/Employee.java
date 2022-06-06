package employee;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Madár Bálint
 */
public class Employee {

    private String firstName, lastName;
    private String job;
    private int salary;

    public Employee(String firstName, String lastName, String job, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public void raiseSalary(int percent) {
        salary = (int) (salary * (1.0 + percent / 100.0));
    }

    private static String readString(Scanner sc, String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    /*A tostring felüldefiniálása*/
    @Override
    public String toString() {
        return "Firstname " + firstName + ", Lastname " + lastName + ", A munkája: " + job + ", Fizetése " + salary;
    }

    private static int readInt(Scanner sc, String msg) {
        System.out.println(msg);
        int i = sc.nextInt();
        sc.nextLine(); //sorvégi enter eltüntetése
        return i;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            employees.add(readEmployee(sc));
            System.out.println(employees.get(i));
        }
        System.out.println("\nKiírás:\n");
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.println(employees.get(i));
        }

        int raise = readInt(sc, "Emelés mértéke (%) = ");
        String job = readString(sc, "Érintett beosztás: ");

        //Megemelem azoknak akiknek ez a beoszása
        //Ez egy gyűjtemény for each
        for (Employee e : employees) {
            if (e.getJob().equals(job)) {
                e.raiseSalary(raise);
                System.out.println(e);
            }
        }

        Employee richMan = employees.get(0);
        for (Employee e : employees) {
            if (e.getSalary() > richMan.getSalary()) {
                richMan = e;

            }
        }

        System.out.println("Legnagyobb fizetésű beosztott: " + richMan);

    }

    private static Employee readEmployee(Scanner sc) {

        String firstName = readString(sc, "Vezetéknév: ");
        String lastName = readString(sc, "Keresztév: ");
        String job = readString(sc, "Beosztás: ");
        int salary = readInt(sc, "Fizetés");
        Employee e = new Employee(firstName, lastName, job, salary);
        return e;
    }

}
