package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.Api.ApiResponse;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get-all")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacherId}")
    public ResponseEntity addCourse(@PathVariable Integer teacherId, @RequestBody @Valid Course course) {
        courseService.addCourse(course, teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    @GetMapping("/get-teacher-name/{id}")
    public ResponseEntity getCourseTeacherName(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(new ApiResponse(courseService.getCourseTeacherName(id)));
    }

}
