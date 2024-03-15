package com.GritAcademyPortal.studentsCourses;

import com.GritAcademyPortal.courses.Courses;
import com.GritAcademyPortal.courses.CoursesRepository;
import com.GritAcademyPortal.students.Students;
import com.GritAcademyPortal.students.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsCoursesService {

    @Autowired
    StudentsCoursesRepository studentsCoursesRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    CoursesRepository coursesRepository;


    public List<StudentsCoursesDTO> getStudentsCourses() {
        List<StudentsCoursesDTO> studentsCoursesDTO = new ArrayList<>();
        studentsCoursesRepository.findAll().forEach(studentscourses -> studentsCoursesDTO.add(this.mapToDTO(studentscourses)));
        return studentsCoursesDTO;
    }

    private StudentsCoursesDTO mapToDTO(StudentsCourses studentsCourses) {
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setId(studentsCourses.getId());

        //Populate DTO with course details
        Courses course = studentsCourses.getCoursesId();
        if (course != null) {
            dto.setCourses_id(course.getId());
            dto.setCourseName(course.getName());
            //Set other course properties as needed
        }

        Students student = studentsCourses.getStudentsId();
        if (student != null) {
            dto.setStudents_id(student.getId());
            dto.setStudentName(student.getFName() + " " + student.getLName());
            dto.setStudentTown(student.getTown());

        }
        return dto;
    }
}
