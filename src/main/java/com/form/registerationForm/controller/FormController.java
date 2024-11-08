package com.form.registerationForm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.form.registerationForm.entity.StudentEntity;
import com.form.registerationForm.serviceLayer.LogicHandler;
import com.form.registerationForm.user.Student;




@Controller
public class FormController {
    @Autowired
    LogicHandler service;
    @GetMapping({"/welcome","/"})
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/register")
    public String goToRegisterPage(ModelMap map){
        Student student  = new Student();
        map.addAttribute("student", student);
        return "registerForm";
    }

    @PostMapping("/registerForm")
    public String submitButtonResp(@ModelAttribute Student s) {
        service.saveStudent(s);

        return "addedStudent";
    }
 
    @GetMapping("/showDetails")
    public String showAll(ModelMap map) {
        map.addAttribute("students", service.get2Student());
        return "display";
    }



    //just redirect to the searchPage.
    @GetMapping("/search")
    public String search(){

        return "searchPage";
    }

    @GetMapping("/searchSubmit")
    public ModelAndView searchSubmit(@RequestParam Long id){
        StudentEntity student= service.searchById(id);
        ModelAndView mav = new ModelAndView();
        if(student!=null){
           
            mav.addObject("student", student);
        }
        else{
            mav.addObject("msg","Student Not Found");
        }
        mav.setViewName("searchResult");
        return mav;
    }

    
    
    @GetMapping("update/{id}")
    public ModelAndView goToUpdatePage(@PathVariable Long id){
        StudentEntity student = service.searchById(id);
        ModelAndView model = new ModelAndView();
        model.addObject("student",student);
        model.setViewName("update");
        return model;
    }
    @PostMapping("/updateSubmit")
    public String updateSubmit(@ModelAttribute StudentEntity student) {
        service.saveStudent(new Student(student.getId(), student.getName(), student.getCourse(), student.getDate(), student.getMobile()));        
        return "redirect:/showDetails";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudentById(id);
        return "redirect:/showDetails";
    }
    
}
