package woods.employeemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import woods.employeemanager.entities.Employee;
import woods.employeemanager.exceptions.UserNotFoundException;
import woods.employeemanager.repositories.EmployeeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployess(){

        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){

        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User by id " + id + " was not found"));
    }

    public Employee updateEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){

        employeeRepository.deleteById(id);
    }
}
