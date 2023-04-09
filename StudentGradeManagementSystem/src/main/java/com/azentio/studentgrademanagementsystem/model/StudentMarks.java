package com.azentio.studentgrademanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentUniqueId;
    private String name;
    private String rollNumber;
    private String classAndSection;
    private int languageSubjectMarks;
    private int streamSubjectOneMarks;
    private int streamSubjectTwoMarks;
    private int streamSubjectThreeMarks;
    private int mathematicsOrLanguageTwoMarks;
    private int optionalSubjectMarks;
}
