package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Api.ApiException;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher updatedTeacher) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Teacher not found");

        teacher.setName(updatedTeacher.getName());
        teacher.setAge(updatedTeacher.getAge());
        teacher.setEmail(updatedTeacher.getEmail());
        teacher.setSalary(updatedTeacher.getSalary());

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Teacher not found");

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Teacher not found");

        return teacher;
    }
}
