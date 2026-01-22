package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private Position position;
    private double salary;

    public Employee(String firstName, String lastName, String email, String company, Position position, double salary) {
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validateEmail(email);

        if (company == null || company.isBlank()) {
            throw new IllegalArgumentException("Company cannot be null or blank");
        }
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.position = position;
        this.salary = salary;
    }


    private void validateName(String name, String fieldName) { 
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or blank"); 
        } 
    } 
    

    private void validateEmail(String email) { 
        if (email == null) {
            throw new IllegalArgumentException("E-mail cannot be null"); 
        } 
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$", Pattern.CASE_INSENSITIVE); 
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid e-mail format"); 
        }
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCompany() {
        return this.company;
    }

    public Position getPosition() {
        return this.position;
    }

    public double getSalary() {
        return this.salary;
    }
}
