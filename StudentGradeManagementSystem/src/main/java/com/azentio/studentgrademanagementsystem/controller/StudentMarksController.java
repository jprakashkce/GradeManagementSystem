package com.azentio.studentgrademanagementsystem.controller;

import com.azentio.studentgrademanagementsystem.model.StudentMarks;
import com.azentio.studentgrademanagementsystem.service.StudentMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentMarksController {

    @Autowired
    private StudentMarksService studentMarksService;

    @PostMapping("/add")
    public StudentMarks addData(@RequestBody StudentMarks studentMarks){
        return studentMarksService.addData(studentMarks);
    }

    @PostMapping("/addMultiple")
    public List<StudentMarks> addMultiple(@RequestBody List<StudentMarks> list){
        return studentMarksService.addMultipleData(list);
    }

    @GetMapping("/get/{id}")
    public StudentMarks getStudentMarksById(@PathVariable int id){
        return studentMarksService.getData(id);
    }

    @GetMapping("/getAll")
    public List<StudentMarks> getStudentMarks(){
        return studentMarksService.getAllData();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentMarks(@PathVariable int id){
        return studentMarksService.deleteData(id);
    }

    @PutMapping("/update")
    public String updateStudentMarks(@RequestBody StudentMarks studentMarks){
        StudentMarks result = studentMarksService.updateData(studentMarks);
        if(result.getName() == null){
            return "ID not present";
        }
        else{
            return "Updated Successfully";
        }
    }
    
    @GetMapping("/grade/{id}")
    public String getStudentGrade(@PathVariable int id){
        return studentMarksService.getGrade(id);
    }
}
