package com.GritAcademyPortal.students;

import com.GritAcademyPortal.courses.CoursesDTO;
import lombok.Data;

import java.util.List;

@Data
public class StudentsDTO {
    List<CoursesDTO> courses;
    private Integer id;
    private String fName;
    private String lName;
    private String town;
}
