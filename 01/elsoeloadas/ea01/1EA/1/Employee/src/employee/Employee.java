/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author zoltanpusztai
 */
public class Employee {

    private String firstName;
    private String secondName;
    private int salary;

    public Employee(String firstName, String secondName, int salary){
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
    }

    public String getName(){
        return firstName + " " + secondName;
    }

    public int getSalary(){
        return salary;
    }

    public void raiseSalary(int raise){
        salary = salary + raise;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Employee e = new Employee("Béla", "Kovács", 1500);
        System.out.println(e.getName() + " fizetése: " + e.getSalary());
        e.raiseSalary(200);
        System.out.println(e.getName() + " fizetése az emelés után : " + e.getSalary());
    }

}
