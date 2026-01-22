import model.*;
import service.*; 
import exception.*;


public class Main {
    public static void main(String[] args) {
        Employee empl1 = new Employee("Jan", "Kowalski","j.kowalski@poczta.pl","Januszex",Position.PROGRAMISTA,10000.00);
        System.out.println(empl1.getFirstName());
        System.out.println(empl1.getLastName());
        System.out.println(empl1.getEmail());
        System.out.println(empl1.getCompany());
        System.out.println(empl1.getPosition());
        System.out.println(empl1.getSalary());
    }
}