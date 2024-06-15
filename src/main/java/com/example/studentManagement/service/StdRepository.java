package com.example.studentManagement.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StdRepository extends JpaRepository<Student,Long> {
    
}
