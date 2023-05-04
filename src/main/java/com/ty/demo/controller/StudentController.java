package com.ty.demo.controller;
import com.ty.demo.model.Student;
import com.ty.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mainUrl")
public class StudentController{
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveDataUri")
    public ResponseEntity<Student> saveData(@RequestBody Student student) {
        Student s= studentService.saveData(student);
        return ResponseEntity.status(202).body(s);
    }

    @GetMapping("/fetchingData/{id}")
    public ResponseEntity<Optional<Student>> getById(@PathVariable("id") @RequestBody long id) {
        Optional<Student> s= Optional.ofNullable(studentService.gettingRecordById(id));
        if (s==null) {
            try{
                throw new Exception("Data are not existing!!!!");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return ResponseEntity.status(404).body(null);
        }
        else
        {
            return ResponseEntity.status(202).body(s);
        }

    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Student>> getAllData(){
        List<Student> s= studentService.getAllData();
        return ResponseEntity.status(202).body(s);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Student> updateData(@PathVariable("id") int id, @RequestBody Student s){
        Student s1= studentService.updateById(id,s);
        if(s1!=null){
            return ResponseEntity.status(200).body(s1);
        }
        else {
            try{
                throw new Exception("Data are not existing!!!!");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Optional<Student>> deleteById(@PathVariable("id") @RequestBody int id){
        Optional<Student> s= studentService.deleteById(id);
        if(s!=null){
            return ResponseEntity.status(200).body(s);
        }
        else{
            try{
                throw new Exception("Data are not existing!!!!");
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return ResponseEntity.status(404).body(null);
        }
    }
}
