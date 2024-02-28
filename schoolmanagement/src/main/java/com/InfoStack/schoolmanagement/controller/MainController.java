package com.InfoStack.schoolmanagement.controller;

import com.InfoStack.schoolmanagement.models.Student;
import com.InfoStack.schoolmanagement.models.Teacher;
import com.InfoStack.schoolmanagement.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    MainService mainService;

    @RequestMapping("")
    public String homepage() {
        return "Sample";
    }

    @RequestMapping("about")
    public String aboutpage() {
        return "about";
    }

    @RequestMapping("services")
    public String servicespage() {
        return "services";
    }

    @RequestMapping("contact")
    public String contactpage() {
        return "contact";
    }

    @RequestMapping("registration")
    public String registrationpage() {
        return "student-registration";
    }

    @RequestMapping("register")
    public String register(@RequestParam("name") String studentName,
                           @RequestParam("mobileno") String mobileNo,
                           @RequestParam("city") String studentCity) {
        Student s = new Student(studentName, studentCity, mobileNo);
        mainService.saveData(s);
        return "sample";
    }

    @RequestMapping("teacher-registration")
    public String teacherRegistration(){
        /*Write the name of webpage
        * present in your templates folder*/
        return "teacher-registration";
    }

    @RequestMapping("register-teacher")
    public String registerTeacher(@RequestParam("name") String teacherName,
                                  @RequestParam("salary") int teacherSalary,
                                  @RequestParam("subject") String teacherSubject){
        Teacher t = new Teacher();
        t.setTeacherName(teacherName);
        t.setTeacherSalary(teacherSalary);
        t.setTeacherSubject(teacherSubject);
        mainService.saveTeacherData(t);
        return "teacher-registration";
    }
}