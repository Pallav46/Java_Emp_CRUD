package org.pallav.emproject;

import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    Employee readEmployee(Long id);
    boolean deleteEmployee(Long id);
    String updateEmployee(Employee employee, Long id);
}
