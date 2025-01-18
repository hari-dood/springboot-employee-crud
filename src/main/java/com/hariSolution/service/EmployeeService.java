package com.hariSolution.service;

// Importing necessary Spring classes and JPA classes
import com.hariSolution.model.Employee; // Employee model class
import com.hariSolution.repository.EmployeeRepository; // Employee repository interface
import java.util.List; // Importing List for handling collections
import org.springframework.beans.factory.annotation.Autowired; // For dependency injection
import org.springframework.data.domain.Page; // For pagination support
import org.springframework.data.domain.PageRequest; // For creating PageRequest objects
import org.springframework.data.domain.Pageable; // For pageable support
import org.springframework.stereotype.Service; // Marks the class as a service component

/**
 * Service class for handling Employee business logic.
 * It interacts with the repository to perform CRUD operations and pagination.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository; // Injecting EmployeeRepository

    // Default constructor for Spring to create an instance of the service
    public EmployeeService() {
    }

    /**
     * Retrieves a list of all employees from the database.
     * @return List<Employee> list of all employees.
     */
    public List<Employee> getAllEmployee() {
        return this.repository.findAll(); // Fetches all employees from the repository
    }

    /**
     * Creates a new employee record in the database.
     * @param employee The employee object to be saved.
     */
    public void createEmployee(Employee employee) {
        this.repository.save(employee); // Saves the employee in the database
    }

    /**
     * Retrieves an employee by their ID.
     * @param id The ID of the employee.
     * @return Employee The employee object.
     * @throws RuntimeException if employee not found.
     */
    public Employee getById(Integer id) {
        // Attempts to find an employee by ID. If not found, throws an exception.
        return (Employee) this.repository.findById(id).orElseThrow(RuntimeException::new);
    }

    /**
     * Updates the employee information in the database.
     * @param employee1 The employee object with updated data.
     */
    public void updateInformation(Employee employee1) {
        this.repository.save(employee1); // Saves the updated employee information in the repository
    }

    /**
     * Deletes an employee record from the database.
     * @param employee1 The employee object to be deleted.
     */
    public void deleteEmployee(Employee employee1) {
        this.repository.delete(employee1); // Deletes the employee from the repository
    }

    /**
     * Retrieves a paginated list of employees from the database.
     * @param pageNumber The page number to retrieve (1-based).
     * @param pageSize The number of employees per page.
     * @return Page<Employee> A page of employees.
     */
    public Page<Employee> findPage(int pageNumber, int pageSize) {
        // Creates a Pageable object with the given page number and size
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return this.repository.findAll(pageable); // Returns a paginated list of employees
    }
}
