package com.InfoStack.schoolmanagement.services;

import com.InfoStack.schoolmanagement.models.Peon;
import com.InfoStack.schoolmanagement.models.Student;
import com.InfoStack.schoolmanagement.models.Teacher;
import com.InfoStack.schoolmanagement.repositories.PeonRepository;
import com.InfoStack.schoolmanagement.repositories.StudentRepository;
import com.InfoStack.schoolmanagement.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository tr;

    @Autowired
    PeonRepository peonRepository;

    public Student saveData(Student s) {
        return studentRepository.save(s);
    }

    public Teacher saveTeacherData(Teacher t) {
        return tr.save(t);
    }

    public Peon savePeonData(Peon p) {
        return peonRepository.save(p);
    }

    public Student getStudentDetails(int rollno) {
        return studentRepository.findById(rollno).get();
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public void deleteStudent(int rollNo){
        studentRepository.deleteById(rollNo);
    }
}
