package com.GritAcademyPortal.studentsCourses;

import com.GritAcademyPortal.courses.CoursesDTO;
import com.GritAcademyPortal.students.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/studentsCourses")
public class StudentsCoursesController {

    @Autowired
    StudentsCoursesService studentsCoursesService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsCoursesDTO>> getStudentsCourses() {
        List<StudentsCoursesDTO> allStudents = studentsCoursesService.getStudentsCourses();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<StudentsCoursesDTO>> createStudentCourse(@ModelAttribute StudentsCourses studentsCourses) {
        System.out.println(studentsCourses);
        /**"studentsCourses =" behöver inte denna delen om vi ska skicka tillbaka hela tabellen och inte bara det tillagda.**/
        studentsCoursesService.saveStudentsCourses(studentsCourses);
        //After saving the new StudentsCourses object, fetch the updated list of StudentsCoursesDTO
        List<StudentsCoursesDTO> studentsCoursesDTOList = studentsCoursesService.getStudentsCourses();
        return new ResponseEntity<>(studentsCoursesDTOList, HttpStatus.CREATED); /** HÄR SKULLE IN DTO, MEN BEHÖVER GÖRA
         LISTAN FÖRST SOM OVAN SOM STÄLLER EN NY FRÅGA TILL DB OCH SKRIVER UT. Egentligen exakt samma som i getStudentsCourses.
         Så vi kallar på den metoden från service för att kunna skriva ut allt på rätt sätt.**/
    }

    /**REMOVE MÅSTE FIXAS. Detta bör funka!!**/
    @PostMapping(value = "/removeStudentsCourses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsCoursesDTO>> removeCoursesById(@RequestParam Long id) {
        System.out.println(id);
        studentsCoursesService.deleteById(id);
        List<StudentsCoursesDTO> studentsCoursesDTOList = studentsCoursesService.getStudentsCourses();
        return new ResponseEntity<>(studentsCoursesDTOList, HttpStatus.CREATED);
    }

}
