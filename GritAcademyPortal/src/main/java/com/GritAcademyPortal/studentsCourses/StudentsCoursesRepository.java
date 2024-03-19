package com.GritAcademyPortal.studentsCourses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsCoursesRepository extends JpaRepository<StudentsCourses, Long> {

    StudentsCourses deleteStudentsCoursesByCourses_id(Long coursesId);
    StudentsCourses deleteStudentsCoursesByStudents_id(Long studentsId);
}