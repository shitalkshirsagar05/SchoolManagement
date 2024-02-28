package com.InfoStack.schoolmanagement.services;

import com.InfoStack.schoolmanagement.models.Student;
import com.InfoStack.schoolmanagement.models.Teacher;
import com.InfoStack.schoolmanagement.repositories.StudentRepository;
import com.InfoStack.schoolmanagement.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository tr;

    public Student saveData(Student s) {
        return studentRepository.save(s);
    }

    public Teacher saveTeacherData(Teacher t) {
        return tr.save(t);
    }
}
