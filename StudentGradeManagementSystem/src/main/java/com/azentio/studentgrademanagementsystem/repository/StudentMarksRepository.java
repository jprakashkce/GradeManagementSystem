package com.azentio.studentgrademanagementsystem.repository;

import com.azentio.studentgrademanagementsystem.model.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {
}
