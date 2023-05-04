package com.ty.demo.service;

import com.ty.demo.model.Student;
import com.ty.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository repo;

    @Override
    public Student saveData(Student student) {
        return repo.save(student);
    }

    @Override
    public Student gettingRecordById(Long id) {
        Student referenceById = repo.getReferenceById(id);

        return referenceById;
    }

    @Override
    public List<Student> getAllData() {
        return repo.findAll();
    }

    @Override
    public Student updateById(int id, Student s) {
        Student s1 = repo.getReferenceById(s.getId());
        if (s1 != null) {
            s1.setId(s.getId());
            s1.setName(s.getName());
            s1.setAge(s.getAge());

            return repo.save(s1);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Student> deleteById(int id){
        Optional<Student> s=repo.findById((long) id);

        if(s.isPresent()){
            repo.deleteById((long)id);
            return s;
        }
        else{
            return null;
        }
    }
}
