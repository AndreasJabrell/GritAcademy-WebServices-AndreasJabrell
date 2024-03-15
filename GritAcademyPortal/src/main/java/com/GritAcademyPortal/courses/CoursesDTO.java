package com.GritAcademyPortal.courses;

import com.GritAcademyPortal.students.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {
    List<StudentsDTO> students;
    private Long id;
    private String name;
    private Integer YHP;
    private String description;
}
