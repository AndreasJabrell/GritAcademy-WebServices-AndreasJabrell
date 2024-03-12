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
    /**
     *Detta är ett änsålänge misslyckat försök på att få ut kurserna som tillhör eleven på ett snyggt sätt.
     * Med ovan mapToDTO blir jobbet gjort men det känns lite klöddigt?
     */
/*    private StudentsCoursesDTO mapToDTO(StudentsCourses studentsCourses) {
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setId(studentsCourses.getId());
        dto.setStudents_id(studentsCourses.getStudentsId().getId());
        dto.setCourseName(studentsCourses.getCoursesId().getName());

        // Populate list of course IDs
        List<Integer> courseIds = new ArrayList<>();
        for (Courses course : studentsCourses.getStudentsId().getCourses()) {
            courseIds.add(course.getId());
            dto.setCourseName(course.getName());
        }
        dto.setCourses_id(courseIds);

        return dto;
        }*/
}
