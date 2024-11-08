package com.form.registerationForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.registerationForm.entity.StudentEntity;

public interface Repo extends JpaRepository<StudentEntity,Long> {

}
