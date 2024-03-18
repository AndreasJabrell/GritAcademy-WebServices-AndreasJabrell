package com.GritAcademyPortal.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.List;

@RestController
@RequestMapping(value ="/students")
public class StudentsController {

    @Autowired
    StudentsService studentsService;

        //To show students and their courses
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudents() {
        List<StudentsDTO> allStudents = studentsService.getStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

        //to show a specific student and its courses
            /**ÄNDRA DENNA ska vara @requestParam**/
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getCoursesForStudents(@RequestParam Long id) {
        List<StudentsDTO> studentsDTO = studentsService.getCoursesForStudents(id);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }
        //shows students with a specific first name and their courses
            /**ÄNDRA DENNA URL + ska vara @requestParam**/
    @GetMapping(value = "/fname/{fName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByfName(@RequestParam(value = "fName") String fName) {
        List<StudentsDTO> studentsDTO = studentsService.getStudentsWithCoursesByfName(fName);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

        /**ÄNDRA DENNA URL + ska vara @requestParam**/
    @GetMapping(value = "/lName/{lName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsBylName(@RequestParam String lName) {
        List<StudentsDTO> studentsDTO = studentsService.getStudentsWithCoursesBylName(lName);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

    /**ÄNDRA DENNA URL + ska vara @requestParam**/
    @GetMapping(value = "/town/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByTown(@RequestParam String town) {
        List<StudentsDTO> studentsDTO = studentsService.getStudentsWithCoursesByTown(town);
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

    /**ÄNDRA DENNA ska vara @requestParam, kan också ändra URL till students/remove/{id} för att vara konsekvent**/
    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> removeStudent(@RequestParam(value = "id") Long id) {
        System.out.println(id);
        studentsService.removeStudentById(id);
        return new ResponseEntity<>(studentsService.getStudents(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Students> createStudent(@ModelAttribute Students student){
        System.out.println(student);
        student = studentsService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
