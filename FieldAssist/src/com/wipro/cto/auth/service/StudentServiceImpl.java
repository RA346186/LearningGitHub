package com.wipro.cto.auth.service;

import java.util.List;

import com.wipro.cto.auth.dao.StudentDAO;
import com.wipro.cto.auth.model.Student;

public class StudentServiceImpl implements StudentService{

	private StudentDAO studentDao;
	
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void create(String name, Integer age) {
		studentDao.create(name, age);
	}

	@Override
	public Student getStudent(Integer id) {
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> listStudents() {
		return studentDao.listStudents();
	}

	@Override
	public void delete(Integer id) {
		studentDao.delete(id);
	}

	@Override
	public void update(Integer id, Integer age) {
		studentDao.update(id, age);
	}

}