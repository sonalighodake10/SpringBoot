package org.student.demo.util.security.dao;

import org.student.demo.util.security.admin.LoginRequest;
import org.student.demo.util.security.admin.User;

public interface LoginDao {
  //This is login method.
  User getUserData(LoginRequest loginRequest);
}
