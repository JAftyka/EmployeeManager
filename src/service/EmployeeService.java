package service;

import model.CompanyStatistics;
import model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Zwraca pracowników z wynagrodzeniem niższym niż bazowa stawka stanowiska.
     */
    public List<Employee> validateSalaryConsistency() {
        return employeeList.stream()
                .filter(e -> e.getSalary() < e.getPosition().getBaseSalary())
                .collect(Collectors.toList());
    }

    /**
     * Zwraca mapę statystyk firm.
     */
    public Map<String, CompanyStatistics> getCompanyStatistics() {
        return employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCompany,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                this::buildStatistics
                        )
                ));
    }

    private CompanyStatistics buildStatistics(List<Employee> employees) {
        String company = employees.get(0).getCompany();
        CompanyStatistics stats = new CompanyStatistics(company);

        stats.setEmployeeNumber(employees.size());

        stats.setAvgSalary(
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0.0)
        );

        stats.setBestPaidEmployee(
                employees.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary))
                        .map(e -> e.getFirstName() + " " + e.getLastName())
                        .orElse(null)
        );

        return stats;
    }
}
