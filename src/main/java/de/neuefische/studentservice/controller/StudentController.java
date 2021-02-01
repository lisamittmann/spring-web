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

@RestController
@RequestMapping("student")
public class StudentController {

    @GetMapping
    public ArrayList<Student> getStudent(){

        return new StudentService().getStudentList();
    }

    @GetMapping("{id}")
    public Student getSingleStudent(@PathVariable String id){

        return new StudentService().getStudent(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT));

    }

}
