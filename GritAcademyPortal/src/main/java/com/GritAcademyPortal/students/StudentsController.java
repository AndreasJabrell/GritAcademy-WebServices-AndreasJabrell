package com.GritAcademyPortal.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @GetMapping(value = "/students/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Students> getStudents(){
        return studentsService.getStudents();
    }

    @GetMapping(value = "/students/{id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Students> getCoursesForStudents(
            @PathVariable(value = "id") Integer id

    ){
        return studentsService.getCoursesForStudents(id);
    }
}
