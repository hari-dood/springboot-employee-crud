package com.hariSolution.model;

// Import JPA annotations for defining the entity and its mapping
import jakarta.persistence.Entity; // Marks this class as a JPA entity
import jakarta.persistence.GeneratedValue; // Used for auto-generating primary key values
import jakarta.persistence.GenerationType; // Defines the strategy for primary key generation
import jakarta.persistence.Id; // Marks the primary key field

// Marks this class as an entity to be mapped to a database table
@Entity
public class Employee {

    // Marks this field as the primary key of the entity
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY // Specifies that the primary key is auto-incremented
    )
    private Integer id;

    // Fields for storing employee details
    private String name; // Employee name
    private String email; // Employee email
    private String department; // Employee department
    private String phoneNumber; // Employee phone number
    private String experience; // Employee experience in years or description

    // Getter and Setter methods for the fields
    // These methods are used to access and modify the private fields

    public Integer getId() {
        return this.id; // Returns the employee's ID
    }

    public void setId(Integer id) {
        this.id = id; // Sets the employee's ID
    }

    public String getName() {
        return this.name; // Returns the employee's name
    }

    public void setName(String name) {
        this.name = name; // Sets the employee's name
    }

    public String getEmail() {
        return this.email; // Returns the employee's email
    }

    public void setEmail(String email) {
        this.email = email; // Sets the employee's email
    }

    public String getDepartment() {
        return this.department; // Returns the employee's department
    }

    public void setDepartment(String department) {
        this.department = department; // Sets the employee's department
    }

    public String getPhoneNumber() {
        return this.phoneNumber; // Returns the employee's phone number
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber; // Sets the employee's phone number
    }

    public String getExperience() {
        return this.experience; // Returns the employee's experience
    }

    public void setExperience(String experience) {
        this.experience = experience; // Sets the employee's experience
    }

    // Default constructor (no-args constructor)
    // Required by JPA to create instances of the entity
    public Employee() {
    }

    // Parameterized constructor
    // Allows initializing an Employee object with specific values
    public Employee(Integer id, String name, String email, String department, String phoneNumber, String experience) {
        this.id = id; // Sets the employee's ID
        this.name = name; // Sets the employee's name
        this.email = email; // Sets the employee's email
        this.department = department; // Sets the employee's department
        this.phoneNumber = phoneNumber; // Sets the employee's phone number
        this.experience = experience; // Sets the employee's experience
    }
}
