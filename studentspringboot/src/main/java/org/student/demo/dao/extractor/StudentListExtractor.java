package org.student.demo.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.student.demo.model.StudentForm;

@Component
public class StudentListExtractor implements ResultSetExtractor<List<StudentForm>> {

	@Override
	public List<StudentForm> extractData(ResultSet rs) throws SQLException, DataAccessException {
		ArrayList<StudentForm> studList=new ArrayList<StudentForm>();
		StudentForm sf=null;
		
		while(rs.next()) {
			sf=new StudentForm();
			sf.setSno(rs.getInt("sno"));
			sf.setSname(rs.getString("sname"));
			sf.setAge(rs.getInt("age"));
			studList.add(sf);
		}
								
		return studList;
	}

}

