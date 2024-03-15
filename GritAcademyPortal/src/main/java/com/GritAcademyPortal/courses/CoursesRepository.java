package com.GritAcademyPortal.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

    List<Courses> findByNameContaining(String name);

    List<Courses> findByDescriptionContaining(String description);

}
