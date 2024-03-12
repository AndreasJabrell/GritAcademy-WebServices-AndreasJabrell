package com.GritAcademyPortal.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    List<Courses> findByNameContainingOrderById(String name);

    List<Courses> findByDescriptionContainingOrderById(String description);

}
