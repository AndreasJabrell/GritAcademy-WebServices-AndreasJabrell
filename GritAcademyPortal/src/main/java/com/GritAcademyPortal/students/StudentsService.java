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
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


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