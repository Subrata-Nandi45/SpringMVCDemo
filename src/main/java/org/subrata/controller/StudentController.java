package org.subrata.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.subrata.entity.Student;
import org.subrata.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> creatreStudent(@RequestBody Student studentReq)
    {
        Student studentResp=studentService.createStuent(studentReq);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        Student studentResp= studentService.getStudent(id);
        if(studentResp==null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent()
    {
         List<Student>studentResp=studentService.getAllStudent();
         return ResponseEntity.ok(studentResp);
    }

}
