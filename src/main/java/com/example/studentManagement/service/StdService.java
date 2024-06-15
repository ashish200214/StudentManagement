package com.example.studentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StdService {
    @Autowired
    StdRepository repository;
    public List<Student> getAllStudent() {
        return repository.findAll();
    }
    public String addStudentInfo(Student student) {
        repository.save(student);
        return "Data Inserted Successfully";
    }
    public Student getStudentById(Long id){
        return repository.findById(id).orElse(null);
    }
    public String updateStudentDetails(Student student,Long id) {
        Student st= getStudentById(id);
        if(st!=null){
            st.setName(student.getName());
            st.setCourse(student.getCourse());
            st.setMobile(student.getMobile());
            repository.save(st);
            return "Data Updated Successfully...";
        }else{
            return "User Not Found...";
        }
    }
    public String deleteStudentDetails(Long id) {
       Student st = getStudentById(id);
       if(st!=null){
        repository.delete(st);
        return "User Deleted Successfully...";
       }else{
        return "User Not Found";
       }
    }
    
    
    
}
