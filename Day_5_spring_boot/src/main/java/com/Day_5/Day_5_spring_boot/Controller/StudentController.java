package com.Day_5.Day_5_spring_boot.Controller;

import com.Day_5.Day_5_spring_boot.Model.Student;
import com.Day_5.Day_5_spring_boot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.FOUND);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<Student>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        try{
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<Student>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        try{
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student has been deleted.", HttpStatus.OK);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<String>("Student with id: " + id + " does not exist", HttpStatus.NOT_FOUND);
        }
    }
}
