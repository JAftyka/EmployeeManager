package model;

public class CompanyStatistics {

    private final String companyName;
    private int employeeNumber;
    private double avgSalary;
    private String bestPaidEmployee;

    public CompanyStatistics(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public String getBestPaidEmployee() {
        return bestPaidEmployee;
    }

    public void setBestPaidEmployee(String bestPaidEmployee) {
        this.bestPaidEmployee = bestPaidEmployee;
    }
}
