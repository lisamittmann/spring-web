package de.neuefische.studentservice.controller;

import de.neuefische.studentservice.provider.Student;
import de.neuefische.studentservice.provider.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("student")
public class StudentController {

    public final StudentService studentService = new StudentService();

    @GetMapping
    public List<Student> getStudent(@RequestParam Optional<String> q){

        return studentService.getStudentList(q.orElse(""));
    }

    @GetMapping("{id}")
    public Student getSingleStudent(@PathVariable String id){

        return studentService.getStudent(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT));

    }

    @PutMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping
    public Student deleteStudent(@RequestBody Student student) {
        return studentService.deleteStudent(student);
    }

}
