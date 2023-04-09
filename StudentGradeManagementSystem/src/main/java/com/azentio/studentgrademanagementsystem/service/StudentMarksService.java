package com.azentio.studentgrademanagementsystem.service;

import com.azentio.studentgrademanagementsystem.model.StudentMarks;
import com.azentio.studentgrademanagementsystem.repository.StudentMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentMarksService {
    @Autowired
    StudentMarksRepository studentMarksRepository;

    public StudentMarks addData(StudentMarks studentMarks){
        return studentMarksRepository.save(studentMarks);
    }
    public List<StudentMarks> addMultipleData(List<StudentMarks> list){
        return studentMarksRepository.saveAll(list);
    }
    public StudentMarks getData(int id) {
        return studentMarksRepository.findById(id).orElse(null);
    }
    public List<StudentMarks> getAllData(){
        return studentMarksRepository.findAll();
    }

    public String deleteData(int id){
        studentMarksRepository.deleteById(id);
        return "Data deleted successfully";
    }

    public StudentMarks updateData(@RequestBody StudentMarks studentMarks){
        StudentMarks oldData = null;
        Optional<StudentMarks> optional = studentMarksRepository.findById(studentMarks.getStudentUniqueId());
        if(optional.isPresent()){
            oldData = optional.get();
            oldData.setStudentUniqueId(studentMarks.getStudentUniqueId());
            oldData.setName(studentMarks.getName());
            oldData.setRollNumber(studentMarks.getRollNumber());
            oldData.setClassAndSection(studentMarks.getClassAndSection());
            oldData.setLanguageSubjectMarks(studentMarks.getLanguageSubjectMarks());
            oldData.setStreamSubjectOneMarks(studentMarks.getStreamSubjectOneMarks());
            oldData.setStreamSubjectTwoMarks(studentMarks.getStreamSubjectTwoMarks());
            oldData.setStreamSubjectThreeMarks(studentMarks.getStreamSubjectThreeMarks());
            oldData.setMathematicsOrLanguageTwoMarks(studentMarks.getMathematicsOrLanguageTwoMarks());
            oldData.setOptionalSubjectMarks(studentMarks.getOptionalSubjectMarks());
            return studentMarksRepository.save(oldData);
        }
        else {
            return new StudentMarks();
        }
    }
    
       public String getGrade(int id){
        if(studentMarksRepository.findById(id).isPresent()) {
            Optional<StudentMarks> optional = studentMarksRepository.findById(id);
            StudentMarks data = optional.get();
            double s1 = data.getLanguageSubjectMarks()();
            double s2 = data.getStreamSubjectOneMarks();
            double s3 = data.getStreamSubjectTwoMarks();
            double s4 = data.getStreamSubjectThreeMarks();
            double s5 = data.getMathematicsOrLanguageTwoMarks();
            double s6 = data.getOptionalSubjectMarks();
            int avg = (int)((s1+s2+s3+s4+s5+s6)/6)/10;
            String grade = "";
            switch(avg){
                case 9: grade = "O";
                        break;
                case 8: grade = "A";
                        break;
                case 7: grade = "B";
                        break;
                case 6: grade = "C";
                        break;
                case 5: grade = "D";
                        break;
                default: grade = "F";
            }

            return "Your Grade :"+grade;
        }else {
            return "ID Not Present";
        }

    }
}
