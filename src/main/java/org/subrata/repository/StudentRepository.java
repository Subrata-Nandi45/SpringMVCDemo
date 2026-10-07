package org.subrata.repository;

import org.springframework.stereotype.Repository;
import org.subrata.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository
{
    private Map<Long, Student> stuedntDB;

    public StudentRepository()
    {
        stuedntDB=new HashMap<>();
    }

    public Student save(Student studentReq)
    {
        stuedntDB.put(studentReq.getId(),studentReq);
        return studentReq;
    }

    public Student findById(Long id)
    {
        return stuedntDB.get(id);
    }

    public List<Student> findAll()
    {
       return new ArrayList<>(stuedntDB.values());
    }


}
