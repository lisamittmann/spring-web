package de.neuefische.studentservice.provider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentService {

    private ArrayList<Student> studentList = new ArrayList<Student>(List.of(
            new Student("no1", "Olaf"),
            new Student("no2", "Sven"),
            new Student("no3", "Marvin"),
            new Student("no4", "Steven")
            ));

    public List<Student> getStudentList(String search){

        return this.studentList.stream().filter(s -> s.getName().contains(search)).collect(Collectors.toList());
    }

    public Optional<Student> getStudent(String id) {
        for (Student student : studentList) {
            if(student.getId().equals(id)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Student addStudent(Student student) {
        if(this.studentList.contains(student)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        this.studentList.add(student);
        return student;
    }

    public Student deleteStudent(Student student) {
        this.studentList.remove(student);
        return student;
    }
}
