package com.hariSolution.repository;

// Importing necessary Spring and JPA classes
import com.hariSolution.model.Employee; // Import the Employee entity
import org.springframework.data.jpa.repository.JpaRepository; // Provides CRUD and pagination methods
import org.springframework.stereotype.Repository; // Marks this as a Spring repository

/**
 * Repository interface for Employee entity.
 * This interface extends JpaRepository to provide built-in methods for
 * database operations like save, findById, delete, and pagination.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No additional code is needed here because JpaRepository provides all the basic
    // CRUD (Create, Read, Update, Delete) operations out of the box.
}
