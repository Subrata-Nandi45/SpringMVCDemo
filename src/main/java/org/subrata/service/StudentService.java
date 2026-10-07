package org.subrata.service;

import org.springframework.stereotype.Service;
import org.subrata.entity.Student;
import org.subrata.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService
{
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStuent(Student studentReq)
    {
        return studentRepository.save(studentReq);
    }

    public Student getStudent(Long id)
    {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudent()
    {
        return studentRepository.findAll();
    }


}
