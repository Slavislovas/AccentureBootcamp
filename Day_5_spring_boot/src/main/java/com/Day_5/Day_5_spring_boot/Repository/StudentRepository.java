package com.Day_5.Day_5_spring_boot.Repository;

import com.Day_5.Day_5_spring_boot.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
