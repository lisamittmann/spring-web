package de.neuefische.studentservice.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {

    private final ArrayList<Student> studentList = new ArrayList<Student>(List.of(
            new Student("no1", "Olaf"),
            new Student("no2", "Sven"),
            new Student("no3", "Marvin"),
            new Student("no4", "Steven")
            ));

    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }

    public Optional<Student> getStudent(String id) {
        for (Student student : studentList) {
            if(student.getId().equals(id)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
}
