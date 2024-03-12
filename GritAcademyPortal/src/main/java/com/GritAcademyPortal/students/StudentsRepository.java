package com.GritAcademyPortal.students;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

    List<Students> findByfNameContainingOrderByFName(String fName);

    List<Students> findBylNameContainingOrderByLName(String lName);

    List<Students> findByTownContainingOrderByTown(String town);

}
