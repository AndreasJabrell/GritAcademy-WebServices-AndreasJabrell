package com.GritAcademyPortal.courses;

import com.GritAcademyPortal.students.Students;
import com.GritAcademyPortal.students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCourses() {
        List<CoursesDTO> allCourses = coursesService.getCourses();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @GetMapping(value = "/description/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByDescription(@RequestParam String description) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByDescription(description);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByIdWithStudents(@RequestParam Long id) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByIdWithStudents(id);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{Name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByName(@RequestParam(value = "name") String name) {
        List<CoursesDTO> studentsDTO = coursesService.getCoursesByName(name);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }
    @GetMapping(value = "/name/students/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByNameWithStudents(@RequestParam String name) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByNameWithStudents(name);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Courses> createCourse(@ModelAttribute Courses course){
        System.out.println(course);
        course = coursesService.saveCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> removeCourse(@RequestParam(value = "id") Long id) {
        System.out.println(id);
        coursesService.removeCourseById(id);
        return new ResponseEntity<>(coursesService.getCourses(), HttpStatus.OK);
    }

}
