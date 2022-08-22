package com.Day_5.Day_5_spring_boot.Service;

import com.Day_5.Day_5_spring_boot.Model.Student;
import com.Day_5.Day_5_spring_boot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        } else{
            throw new EntityNotFoundException();
        }
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student, Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            studentRepository.save(existingStudent);
            return existingStudent;
        } else{
            throw new EntityNotFoundException();
        }
    }

    public void deleteStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException();
        }
    }


}
