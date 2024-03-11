package com.GritAcademyPortal.studentsCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsCoursesService {

    @Autowired
    StudentsCoursesRepository studentsCoursesRepository;

    public List<StudentsCoursesDTO> getStudentsCourses() {

        List<StudentsCoursesDTO> studentsCoursesDTO = new ArrayList<>();
        studentsCoursesRepository.findAll().forEach(studentscourses -> studentsCoursesDTO.add(this.mapToDTO(studentscourses)));

        return studentsCoursesDTO;

    }

    private StudentsCoursesDTO mapToDTO(StudentsCourses studentscourses) {
        StudentsCoursesDTO dto = new StudentsCoursesDTO();
        dto.setId(studentscourses.getId());
        dto.setCourses_id(studentscourses.getCoursesId().getId());
        dto.setStudents_id(studentscourses.getStudentsId().getId());
        return dto;

    }

/*    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        dto.setCourses(students.getCourses().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }
    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
*//*        dto.setStudents(courses.getStudents().stream()
                .map(this::mapToDTOS)
                .collect(Collectors.toList()));*//*
        return dto;
    }*/

}
