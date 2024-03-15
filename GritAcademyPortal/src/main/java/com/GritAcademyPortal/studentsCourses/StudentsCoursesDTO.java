package com.GritAcademyPortal.studentsCourses;

import lombok.Data;

@Data
public class StudentsCoursesDTO {
    private Long id;
    private Long students_id;
    private Long courses_id;
    private String courseName;
    private String studentName;
    private String studentTown;
}
