package com.hariSolution.controller;

// Import necessary classes and packages
import com.hariSolution.model.Employee; // Employee model class
import com.hariSolution.service.EmployeeService; // Employee service for business logic
import java.util.List; // To handle lists of employees
import org.springframework.beans.factory.annotation.Autowired; // To inject dependencies
import org.springframework.data.domain.Page; // To manage pagination
import org.springframework.stereotype.Controller; // To mark this class as a Spring Controller
import org.springframework.ui.Model; // To pass data to the view
import org.springframework.web.bind.annotation.*; // To handle HTTP requests

// Annotates this class as a Spring MVC Controller
@Controller
// Maps all requests starting with "/employee" to this controller
@RequestMapping({"/employee"})
public class EmployeeController {

    // Injects the EmployeeService bean into this controller
    @Autowired
    private EmployeeService service;

    // Default constructor
    public EmployeeController() {
    }

    // Handles GET requests to "/employee/home"
    // Displays all employees on the home page
    @GetMapping({"/home"})
    public String getAllEmployee(Model model) {
        // Redirects to the first page of employees
        return this.getAllEmployeeWithPage(model, 1);
    }

    // Handles GET requests to "/employee/page/{pageNumber}"
    // Implements pagination for employee records
    @GetMapping({"/page/{pageNumber}"})
    public String getAllEmployeeWithPage(Model model, @PathVariable("pageNumber") int currentPage) {
        int pageSize = 5; // Number of employees per page
        // Retrieves a specific page of employees
        Page<Employee> page = this.service.findPage(currentPage, pageSize);
        int totalPage = page.getTotalPages(); // Total number of pages
        long totalItem = page.getTotalElements(); // Total number of employees
        List<Employee> employees = page.getContent(); // Employees in the current page

        // Adds pagination data to the model for the view
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("employees", employees);

        // Returns the "index" view to display employees
        return "index";
    }

    // Handles GET requests to "/employee/createForm"
    // Shows a form to create a new employee
    @GetMapping({"/createForm"})
    public String getFormForSaveInformation(Model model) {
        Employee employee = new Employee(); // Creates a new empty Employee object
        model.addAttribute("employees", employee); // Adds it to the model
        return "formCreation"; // Returns the view for the form
    }

    // Handles POST requests to "/employee/saveEmployee"
    // Saves a new employee
    @PostMapping({"/saveEmployee"})
    public String createEmployee(@ModelAttribute Employee employee) {
        this.service.createEmployee(employee); // Saves the employee using the service
        return "redirect:/employee/home"; // Redirects to the home page
    }

    // Handles GET requests to "/employee/edit/{id}"
    // Shows the form to edit an existing employee
    @GetMapping({"/edit/{id}"})
    public String EditInformation(@PathVariable("id") Integer id, Model model) {
        Employee employee = this.service.getById(id); // Retrieves the employee by ID
        model.addAttribute("employee", employee); // Adds it to the model
        return "editForm.html"; // Returns the view for editing
    }

    // Handles POST requests to "/employee/edit/{id}"
    // Updates an existing employee's information
    @PostMapping({"/edit/{id}"})
    public String EditInformation(@PathVariable("id") Integer id, @ModelAttribute Employee employee) {
        Employee employee1 = this.service.getById(id); // Retrieves the existing employee
        // Updates employee fields with new data
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setDepartment(employee.getDepartment());
        employee1.setExperience(employee.getExperience());
        this.service.updateInformation(employee1); // Saves the updated employee
        return "redirect:/employee/home"; // Redirects to the home page
    }

    // Handles GET requests to "/employee/delete/{id}"
    // Deletes an employee
    @GetMapping({"/delete/{id}"})
    public String deleteEmployee(@PathVariable("id") Integer id) {
        Employee employee1 = this.service.getById(id); // Retrieves the employee by ID
        this.service.deleteEmployee(employee1); // Deletes the employee
        return "redirect:/employee/home"; // Redirects to the home page
    }
}
