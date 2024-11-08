package com.form.registerationForm.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.form.registerationForm.entity.StudentEntity;
import com.form.registerationForm.repository.Repo;
import com.form.registerationForm.user.Student;

@Service
public class LogicHandler {
    @Autowired
    Repo repository;
    public void saveStudent(Student student){
        StudentEntity entityStudent = new StudentEntity();
        entityStudent.setName(student.getName());
        entityStudent.setCourse(student.getCourse());
        entityStudent.setDate(student.getDate());
        entityStudent.setId(student.getId());
        entityStudent.setMobile(student.getMobile());
        repository.save(entityStudent);
    }

    public List<StudentEntity> get2Student(){
        return repository.findAll();
    }

    public StudentEntity searchById(Long id){
        Optional<StudentEntity>student = repository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    public void deleteStudentById(Long id) {
        repository.delete(searchById(id));
    }



}
