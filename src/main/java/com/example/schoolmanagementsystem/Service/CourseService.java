package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.Model.Course;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.CourseRepository;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course, Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);

        if (teacher == null)
            throw new ApiException("Cannot add course without teacher");

        course.setTeacher(teacher);

        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course updatedCourse) {
        Course course = courseRepository.findCourseById(id);

        if (course == null)
            throw new ApiException("Course not found");

        course.setName(updatedCourse.getName());

        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);

        if (course == null)
            throw new ApiException("Course not found");

        courseRepository.delete(course);
    }

    public String getCourseTeacherName(Integer id){
        Course course = courseRepository.findCourseById(id);

        if(course == null)
            throw new ApiException("Course not found");

        return course.getTeacher().getName();
    }
}
