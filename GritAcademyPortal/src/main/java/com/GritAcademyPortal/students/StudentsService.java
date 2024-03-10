package com.GritAcademyPortal.students;

import com.GritAcademyPortal.courses.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    List<Students> getStudents(){
        return studentsRepository.findAll();
    }

    List<Students> getCoursesForStudents(Integer id){
        return studentsRepository.findCoursesById(id);
    }
}
