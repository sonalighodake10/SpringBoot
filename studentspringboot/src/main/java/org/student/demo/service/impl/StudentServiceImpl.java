package org.student.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.student.demo.dao.StudentDao;
import org.student.demo.model.StudentForm;
import org.student.demo.service.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
  private StudentDao studentDao;

@Override
public List<StudentForm> getStudListService() {
	List<StudentForm> studList=studentDao.getStudList();
	return studList;
}

@Override
public StudentForm getStudBySnoService(int sno) {
	StudentForm sf=studentDao.getStudBySno(sno);
	return sf;
}

@Override
public void insertStudService(StudentForm studentForm) {
	studentDao.insertStud(studentForm);	
}

@Override
public void updateStudService(StudentForm studentForm) {
	studentDao.updateStud(studentForm);	
}

@Override
public void deleteStudService(int sno) {
	studentDao.deleteStud(sno);	
}
  
}

