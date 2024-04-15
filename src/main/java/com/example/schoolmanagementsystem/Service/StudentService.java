package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Repository.CourseRepository;
import com.example.schoolmanagementsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student updatedStudent) {
        Student student = studentRepository.findStudentById(id);

        if (student == null)
            throw new ApiException("Student not found");

        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        student.setMajor(updatedStudent.getMajor());

        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);

        if (student == null)
            throw new ApiException("Student not found");

        studentRepository.delete(student);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);

        if (student == null || course == null)
            throw new ApiException("Cannot assign student to course");

        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);

        if (student == null)
            throw new ApiException("Student not found");

        student.setMajor(major);

        student.getCourses().forEach(course -> {
            course.getStudents().remove(student);
            courseRepository.save(course);
        });

        student.getCourses().clear();

        studentRepository.save(student);
    }

    public List<Student> getStudentsByCourse(Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);

        if (course == null)
            throw new ApiException("Course not found");

        return course.getStudents().stream().toList();
    }

}
