package com.GritAcademyPortal.studentsCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsCoursesController {

    @Autowired
    StudentsCoursesService studentsCoursesService;

    @GetMapping(value = "/studentscourses/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsCoursesDTO>> getStudentsCourses() {
        List<StudentsCoursesDTO> allStudents = studentsCoursesService.getStudentsCourses();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

}