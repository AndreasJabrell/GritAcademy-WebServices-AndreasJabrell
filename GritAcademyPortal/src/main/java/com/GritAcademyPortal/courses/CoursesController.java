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
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping(value = "/courses/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCourses() {
        List<CoursesDTO> allCourses = coursesService.getCourses();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    @GetMapping(value = "/coursesname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByName(@PathVariable(value = "name") String name) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByName(name);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/coursesdescription/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByDescription(@PathVariable(value = "description") String description) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByDescription(description);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/coursesbyidwithstudents/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByIdWithStudents(@PathVariable(value = "id") Long id) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByIdWithStudents(id);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/coursesbynamewithstudents/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> getCoursesByNameWithStudents(@PathVariable(value = "name") String name) {
        List<CoursesDTO> coursesDTO = coursesService.getCoursesByNameWithStudents(name);
        return new ResponseEntity<>(coursesDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createCourse")
    public ResponseEntity<Courses> createCourse(@ModelAttribute Courses course){
        System.out.println(course);
        course = coursesService.saveCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    /**ÄNDRA DENNA ska vara @requestParam, kan också ändra URL till students/remove/{id} för att vara konsekvent**/
    @RequestMapping(value = "/removeCourse/{id}", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CoursesDTO>> removeCourse(@RequestParam(value = "id") Long id) {
        System.out.println(id);
        coursesService.removeCourseById(id);
        return new ResponseEntity<>(coursesService.getCourses(), HttpStatus.OK);
    }

}
