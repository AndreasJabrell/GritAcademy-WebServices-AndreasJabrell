package com.GritAcademyPortal.students;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Long> {
    //Containg makes it so it searches for results like, searching TownContaining="Hel" will return Helsingborg and so on
    List<Students> findByfNameContaining(String fName);

    List<Students> findBylNameContaining(String lName);

    List<Students> findByTownContainingOrderByTown(String town);

}
