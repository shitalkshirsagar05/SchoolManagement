package com.InfoStack.schoolmanagement.controller;

import com.InfoStack.schoolmanagement.models.Student;
import com.InfoStack.schoolmanagement.models.StudentMarks;
import com.InfoStack.schoolmanagement.services.MainService;
import com.InfoStack.schoolmanagement.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/marks")
public class MarksController {
    @Autowired
    MainService mainService;
    @Autowired
    MarksService marksService;

    @RequestMapping("/entry")
    public String marksentry() {
        return "student-marks-entry";
    }

    @RequestMapping("/save")
    public String marksinsert(@RequestParam("rollNo") int rollNo,
                              @RequestParam("subject1") int subject1,
                              @RequestParam("subject2") int subject2,
                              @RequestParam("subject3") int subject3) {
        Student s = mainService.getStudentDetails(rollNo);
        StudentMarks sm = new StudentMarks();
        sm.setSubject1(subject1);
        sm.setSubject2(subject2);
        sm.setSubject3(subject3);
        sm.setStudent(s);
        marksService.saveData(sm);
        return "redirect:/marks/entry";
    }
}
