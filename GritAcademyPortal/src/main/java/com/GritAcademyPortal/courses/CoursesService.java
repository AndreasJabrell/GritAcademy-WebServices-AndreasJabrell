package com.GritAcademyPortal.courses;

import com.GritAcademyPortal.students.Students;
import com.GritAcademyPortal.students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    public List<CoursesDTO> getCourses() {

        List<CoursesDTO> coursesDTO = new ArrayList<>();
        coursesRepository.findAll().forEach(courses -> coursesDTO.add(this.mapToDTOBasic(courses)));

        return coursesDTO;

    }

    public void removeCourseById(Long id) {
        coursesRepository.deleteById(id);
    }

    public Courses saveCourse(Courses courses) {
        return coursesRepository.save(courses);
    }

    public List<CoursesDTO> getCoursesByName(String name) {
        List<Courses> coursesList = coursesRepository.findByNameContaining(name);
        if (!coursesList.isEmpty()) {
            return coursesList.stream()
                    .map(this::mapToDTOBasic)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<CoursesDTO> getCoursesByDescription(String description) {
        List<Courses> coursesList = coursesRepository.findByDescriptionContaining(description);
        if (!coursesList.isEmpty()) {
            return coursesList.stream()
                    .map(this::mapToDTOBasic)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<CoursesDTO> getCoursesByIdWithStudents(Long id) {
        Optional<Courses> studentsList = coursesRepository.findById(id);
        if (studentsList.isPresent()) {
            return studentsList.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public List<CoursesDTO> getCoursesByNameWithStudents(String name) {
        List<Courses> coursesList = coursesRepository.findByNameContaining(name);
        if (!coursesList.isEmpty()) {
            return coursesList.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    //Used to only display the course/s
    private CoursesDTO mapToDTOBasic(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
        return dto;
    }
    //Used to display courses with students as it also has a list of "StudentsDTO" derived from the mapToDTO below this one

    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
        dto.setStudents(courses.getStudents().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private StudentsDTO mapToDTO(Students students) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(students.getId());
        dto.setFName(students.getFName());
        dto.setLName(students.getLName());
        dto.setTown(students.getTown());
        return dto;
    }

}
