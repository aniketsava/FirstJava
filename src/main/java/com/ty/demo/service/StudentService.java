package com.ty.demo.service;

import com.ty.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveData(Student student);
    public Student gettingRecordById(Long id);
    public List<Student> getAllData();
    public Student updateById(int id, Student s);
    public Optional<Student> deleteById(int id);
}
