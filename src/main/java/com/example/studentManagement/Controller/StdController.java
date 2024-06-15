package com.example.studentManagement.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagement.service.StdService;
import com.example.studentManagement.service.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class StdController {
    @Autowired
    StdService service;
    @GetMapping("student")
    public List<Student> getMethodName() {
        return service.getAllStudent();
    }
    
    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
        return service.addStudentInfo(student);
    }

    @PutMapping("student/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student student) {
      return  service.updateStudentDetails(student,id);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return service.deleteStudentDetails(id);
    }
}
