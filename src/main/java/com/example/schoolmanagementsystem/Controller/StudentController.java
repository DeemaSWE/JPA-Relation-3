package com.example.schoolmanagementsystem.Controller;


import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get-all")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }

    @PutMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity assignCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignStudentToCourse(studentId, courseId);
        return ResponseEntity.status(200).body("Student assigned to course successfully");
    }

    @PutMapping("/change-major/{studentId}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeMajor(studentId, major);
        return ResponseEntity.status(200).body("Major changed successfully");
    }

    @GetMapping("/get-all/{courseId}")
    public ResponseEntity getStudentsByCourse(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(studentService.getStudentsByCourse(courseId));
    }
}
