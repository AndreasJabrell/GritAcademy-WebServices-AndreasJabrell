package com.GritAcademyPortal.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping(value = "/courses/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Courses> getCourses(){
        return coursesService.getCourses();
    }


}
