package org.student.demo.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.student.demo.dao.StudentDao;
import org.student.demo.dao.extractor.StudentExtractor;
import org.student.demo.dao.extractor.StudentListExtractor;
import org.student.demo.model.StudentForm;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class StudentDaoImpl implements StudentDao {
  private JdbcTemplate jdbcTemplate;
  private StudentListExtractor studentListExtractor;
  private StudentExtractor studentExtractor; 
  
@Override
public List<StudentForm> getStudList() {
	List<StudentForm> studList=jdbcTemplate.query("Select * from student order by sno", studentListExtractor::extractData);
	return studList;
}

@Override
public StudentForm getStudBySno(int sno) {
	StudentForm sf=jdbcTemplate.query("Select * from student where sno=" + sno, studentExtractor::extractData);
	return sf;
}

@Override
public void insertStud(StudentForm studentForm) {
	String query="Insert into student values(" + studentForm.getSno() + ",'" + studentForm.getSname() + "'," + studentForm.getAge() + ")";
	jdbcTemplate.update(query);
}

@Override
public void updateStud(StudentForm studentForm) {
   String query="Update student set sname='" + studentForm.getSname() + "', age=" + studentForm.getAge() + " where sno=" + studentForm.getSno();
   jdbcTemplate.update(query);
}

@Override
public void deleteStud(int sno) {
  String query="Delete from student where sno=" + sno;
  jdbcTemplate.update(query);
}
    
}

