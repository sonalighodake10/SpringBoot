package org.student.demo.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.student.demo.model.StudentForm;

@Component
public class StudentExtractor implements ResultSetExtractor<StudentForm> {

	@Override
	public StudentForm extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		StudentForm sf=new StudentForm();
		
		if(rs.next()) {
			sf.setSno(rs.getInt("sno"));
			sf.setSname(rs.getString("sname"));
			sf.setAge(rs.getInt("age"));
		}
		
		return sf;
	}
  
}

