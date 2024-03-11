package com.GritAcademyPortal.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    public List<CoursesDTO> getCourses() {

        List<CoursesDTO> coursesDTO = new ArrayList<>();
        coursesRepository.findAll().forEach(courses -> coursesDTO.add(this.mapToDTO(courses)));

        return coursesDTO;

    }


    private CoursesDTO mapToDTO(Courses courses) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(courses.getId());
        dto.setName(courses.getName());
        dto.setYHP(courses.getYHP());
        dto.setDescription(courses.getDescription());
        return dto;
    }
}
