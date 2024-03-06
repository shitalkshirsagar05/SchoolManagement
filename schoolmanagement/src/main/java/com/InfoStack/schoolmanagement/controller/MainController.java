package com.InfoStack.schoolmanagement.controller;

import com.InfoStack.schoolmanagement.models.Peon;
import com.InfoStack.schoolmanagement.models.Student;
import com.InfoStack.schoolmanagement.models.Teacher;
import com.InfoStack.schoolmanagement.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @RequestMapping("student/registration")
    public String registrationpage() {
        return "student-registration";
    }

    @RequestMapping("student/register")
    public String register(@RequestParam("name") String studentName,
                           @RequestParam("mobileno") String mobileNo,
                           @RequestParam("city") String studentCity) {
        Student s = new Student(studentName, studentCity, mobileNo);
        mainService.saveData(s);
        return "redirect:/student";
    }

    @RequestMapping("teacher-registration")
    public String teacherRegistration() {
        /*Write the name of webpage
         * present in your templates folder*/
        return "teacher-registration";
    }

    @RequestMapping("register-teacher")
    public String registerTeacher(@RequestParam("name") String teacherName,
                                  @RequestParam("salary") int teacherSalary,
                                  @RequestParam("subject") String teacherSubject) {
        Teacher t = new Teacher();
        t.setTeacherName(teacherName);
        t.setTeacherSalary(teacherSalary);
        t.setTeacherSubject(teacherSubject);
        mainService.saveTeacherData(t);
        return "teacher-registration";
    }

    @RequestMapping("peon/registration")
    public String peonRegistration() {
        return "peon-registration";
    }

    @RequestMapping("peon/register")
    public String registerPeon(@RequestParam("name") String peonName,
                               @RequestParam("salary") int peonSalary,
                               @RequestParam("work") String peonWork) {
        Peon p = new Peon();
        p.setPeonName(peonName);
        p.setPeonSalary(peonSalary);
        p.setPeonWork(peonWork);

        mainService.savePeonData(p);
        return "peon";
    }
//    @RequestMapping("examIncharge/registeration")
//    public String registeration(@RequestParam())

    @RequestMapping("student/{rollno}")
    public String getStudent(@PathVariable("rollno") int rollno, ModelMap m) {
        Student s = mainService.getStudentDetails(rollno);
        System.out.println(s.getName());
        System.out.println(s.getCity());
        m.addAttribute("student",s);
        return "student-details";
    }

    @RequestMapping("student")
    public String getAllStudents(ModelMap m) {
        List<Student> studentList = mainService.getAllStudents();
        m.addAttribute("studentList",studentList);
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getRollNo());
            System.out.println(studentList.get(i).getName());
            System.out.println(studentList.get(i).getMobileNo());
            System.out.println(studentList.get(i).getCity());
            System.out.println("____________________________");
        }
        return "students-table";
    }

    @RequestMapping("student/edit/{rollno}")
    public String editStudentForm(@PathVariable("rollno") int rollNo,ModelMap m){
        Student s = mainService.getStudentDetails(rollNo);
        m.addAttribute("student",s);
        return "student-edit";
    }

    @RequestMapping("student/update")
    public String update(@RequestParam("rollno") int rollNo,
                          @RequestParam("name") String studentName,
                           @RequestParam("mobileno") String mobileNo,
                           @RequestParam("city") String studentCity) {
        Student s = new Student(rollNo,studentName, studentCity, mobileNo);
        mainService.saveData(s);
        return "redirect:/student";
    }

    @RequestMapping("student/delete/{rollno}")
    public String delete(@PathVariable("rollno") int rollNo){
        mainService.deleteStudent(rollNo);
        return "redirect:/student";
    }
}