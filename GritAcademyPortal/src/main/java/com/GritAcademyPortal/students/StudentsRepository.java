package com.GritAcademyPortal.students;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {

    List<Students> findByfNameContaining(String fName);

    List<Students> findBylNameContaining(String lName);

    List<Students> findByTownContainingOrderByTown(String town);

    void deleteStudentsById(Long id);
}
