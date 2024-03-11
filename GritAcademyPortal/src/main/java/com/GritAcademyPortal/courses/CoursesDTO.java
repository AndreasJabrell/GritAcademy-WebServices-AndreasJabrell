package com.GritAcademyPortal.courses;

import lombok.Data;

@Data
public class CoursesDTO {
    private Integer id;
    private String name;
    private Integer YHP;
    private String description;
    //List<StudentsDTO> students;
}
