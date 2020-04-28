package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer> {
}
