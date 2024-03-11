package com.GritAcademyPortal.students;

import com.GritAcademyPortal.courses.Courses;
import com.GritAcademyPortal.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> getStudents() {
        List<StudentsDTO> studentsDTO = new ArrayList<>();

        studentsRepository.findAll().forEach(students -> studentsDTO.add(this.mapToDTO(students)));
        return studentsDTO;

    }

    public List<StudentsDTO> getCoursesForStudents(Integer id) {
        Optional<Students> students = studentsRepository.findById(id).map(students1 -> {
            students1.getCourses().size();
            return students1;
        });
        return students.stream()
                /**
                 *Istället för .map här kan man använda olika roliga grejer för att sortera/räkna/splitta osv.
                 **/
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Använd 2 mapToDTO för students, en med courses lista och en utan. Samma för Courses.
     * Vill man inte använda 2 listor kanske man kan göra en if-sats eller nåt för att kolla
     * om man ska använda lista eller inte. Så man kolla om man behöver listan eller inte med nån hjälp, typ flagga?
     * Kanske nåt sånt här?
     *
     *     private StudentsDTO mapToDTO(Students students, Boolean addList) {
     *         StudentsDTO dto = new StudentsDTO();
     *         dto.setId(students.getId());
     *         dto.setFName(students.getFName());
     *         dto.setLName(students.getLName());
     *         dto.setTown(students.getTown());
     *         if (addList)dto.setCourses(students.getCourses().stream()
     *                 .map(students -> mapToDTO(students, false))
     *                 .collect(Collectors.toList()));
     *         return dto;
     *     }
     *     **/
    private StudentsDTO mapToDTO(Students students) {
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
/*        dto.setStudents(courses.getStudents().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));*/
        return dto;
    }

}
