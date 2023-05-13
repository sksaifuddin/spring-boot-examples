package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //----------------------- GET request examples ------------------------//

    /**
     * Rest API that returns Java Bean as JSON
     */
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Ramesh", "Rao");
        return ResponseEntity.ok().header("custom-header", "saif")
                .body(student);
    }

    /**
     * Rest API that return List as JSON
     */
    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Saif", "shaik"));
        students.add(new Student(2, "Atu", "shaik"));
        return students;
    }

    /**
     * Rest API with path Variables
     * URL: http://localhost:8080/students/1/shaik/saifuddin
     */
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }


    /**
     * REST API with Request Params
     * URL: http://localhost:8080/students/query?id=1&first-name=saif&last-name=shaik
     */
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam("first-name") String firstName,
                                          @RequestParam("last-name") String lastName) {
        return new Student(id, firstName, lastName);
    }

    // ------------------------------------ GET request examples end -----------------------------------//

    // ------------------------------------ POST request examples Start ------------------------------//

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    // ------------------------------------ POST request examples end ------------------------------//

    // ------------------------------------ PUT request examples Start ------------------------------//

    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    // ------------------------------------ PUT request examples end ------------------------------//

    // ------------------------------------ DELETE request examples Start ------------------------------//

    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "Student deleted successfully!";
    }

    // ------------------------------------ DELETE request examples Start ------------------------------//

}
