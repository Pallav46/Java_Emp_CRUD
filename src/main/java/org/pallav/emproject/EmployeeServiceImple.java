package org.pallav.emproject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeEntities) {
            Employee employee = new Employee();
            employee.setName(employeeEntity.getName());
            employee.setEmail(employeeEntity.getEmail());
            employee.setId(employeeEntity.getId());
            employee.setPhone(employeeEntity.getPhone());
            employees.add(employee);
        }

        return employees;
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity emp_ent = employeeRepository.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(emp_ent, emp);

        return emp;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Employee employee, Long id) {
        EmployeeEntity existing_emp = employeeRepository.findById(id).get();
        
        existing_emp.setEmail(employee.getEmail());
        existing_emp.setPhone(employee.getPhone());
        existing_emp.setName(employee.getName());

        employeeRepository.save(existing_emp);

        return "Updated Sucessfully";
    }

}
