package org.student.demo.util.security.dao.impl;

import org.student.demo.util.security.admin.LoginRequest;
import org.student.demo.util.security.admin.User;
import org.student.demo.util.security.dao.LoginDao;
//import org.javapatil.basicbootproject.util.security.dao.extractor.CheckUserExtractor;
import org.student.demo.util.security.dao.extractor.LoginExtractor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class LoginDaoImpl implements LoginDao {
  private JdbcTemplate jdbcTemplate;
  private LoginExtractor loginExtractor; 
  //private CheckUserExtractor checkUserExtractor;

@Override
public User getUserData(LoginRequest loginRequest) {
	return jdbcTemplate.query("select * from login('" + loginRequest.getUserName() + "', '" + loginRequest.getPassword() + "')" , loginExtractor::extractData);
}
  
}
