package com.GritAcademyPortal.students;

import com.GritAcademyPortal.courses.Courses;
import com.GritAcademyPortal.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> getStudents() {
        List<StudentsDTO> studentsDTO = new ArrayList<>();

        studentsRepository.findAll().forEach(students -> studentsDTO.add(this.mapToDTOBasic(students)));
        return studentsDTO;

    }

    public void removeStudentById(Long id) {
        studentsRepository.deleteById(id);
    }

    public Students saveStudent(Students students) {
        return studentsRepository.save(students);
    }


    public List<StudentsDTO> getCoursesForStudents(Long id) {
        Optional<Students> students = studentsRepository.findById(id).map(students1 -> {
            students1.getCourses().size();
            return students1;
        });
        return students.stream()
                /**Istället för .map här kan man använda olika roliga grejer för att sortera/räkna/splitta osv.**/
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentsDTO> getStudentsWithCoursesByfName(String fName) {
        List<Students> studentsList = studentsRepository.findByfNameContaining(fName);
        if (!studentsList.isEmpty()) {
            return studentsList.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<StudentsDTO> getStudentsWithCoursesBylName(String lName) {
        List<Students> studentsList = studentsRepository.findBylNameContaining(lName);
        if (!studentsList.isEmpty()) {
            return studentsList.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<StudentsDTO> getStudentsWithCoursesByTown(String town) {
        List<Students> studentsList = studentsRepository.findByTownContainingOrderByTown(town);
        if (!studentsList.isEmpty()) {
            return studentsList.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    //Used to only display the student/s
    private StudentsDTO mapToDTOBasic(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        return dto;
    }


    //Used to display students with courses as it also has a list of "CoursesDTO" derived from the mapToDTO below this one
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
