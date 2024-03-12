package com.GritAcademyPortal.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @GetMapping(value = "/students/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudents() {
        List<StudentsDTO> allStudents = studentsService.getStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping(value = "/students/{id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getCoursesForStudents(
            @PathVariable(value = "id") Integer id
    ) {
        List<StudentsDTO> studentsDTO = studentsService.getCoursesForStudents(id);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/studentsfName/{fName}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByfName(@PathVariable(value = "fName") String fName) {
        List<StudentsDTO> studentsDTO = studentsService.getStudentsWithCoursesByfName(fName);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/studentslName/{lName}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsBylName(@PathVariable(value = "lName") String lName) {
        List<StudentsDTO> studentsDTO = studentsService.getStudentsWithCoursesBylName(lName);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/studentstown/{town}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByTown(@PathVariable(value = "town") String town) {
        List<StudentsDTO> studentsDTO = studentsService.getStudentsWithCoursesByTown(town);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }


}
