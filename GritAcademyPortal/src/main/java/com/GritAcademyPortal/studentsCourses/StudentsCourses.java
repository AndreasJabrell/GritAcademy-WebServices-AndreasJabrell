package com.GritAcademyPortal.studentsCourses;

import com.GritAcademyPortal.courses.Courses;
import com.GritAcademyPortal.students.Students;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "students_courses")
@Table(name = "students_courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsCourses {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "students_id", referencedColumnName = "id")
    private Students students_id;

    @ManyToOne
    @JoinColumn(name = "courses_id", referencedColumnName = "id")
    private Courses courses_id;
}
