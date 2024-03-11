package com.GritAcademyPortal.courses;

import com.GritAcademyPortal.students.StudentsDTO;
import lombok.Data;

import java.util.List;

@Data
public class CoursesDTO {
    private Integer id;
    private String name;
    private Integer YHP;
    private String description;
    List<StudentsDTO> students;
}
