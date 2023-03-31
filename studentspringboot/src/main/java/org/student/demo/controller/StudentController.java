package org.student.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.student.demo.model.StudentForm;
import org.student.demo.service.StudentService;
import org.student.demo.util.security.admin.BaseResource;
import org.student.demo.util.security.admin.User;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/admin/students")
@CrossOrigin
public class StudentController extends BaseResource {
    private StudentService studentService;  
		
	@GetMapping
	public List<StudentForm> getStudListCtrl(@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		
		User user = getUser(request);

	     if(user==null) return null;
	  List<StudentForm> studList=studentService.getStudListService();
	  return studList;
	}
	
	@GetMapping("/{snum}")
	public StudentForm getStudBySnoCtrl(@PathVariable(value = "snum") int sno,@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		StudentForm studentForm=studentService.getStudBySnoService(sno);
		return studentForm;
	}
	
	@PostMapping
	public void insertStudCtrl(@RequestBody StudentForm studentForm,@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		studentService.insertStudService(studentForm);
	}
	
	@PutMapping
	public void updateStudCtrl(@RequestBody StudentForm studentForm,@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		studentService.updateStudService(studentForm);
	}
	
	@DeleteMapping("/{snum}")
	public void deleteStudCtrl(@PathVariable(value = "snum") int sno,@RequestHeader("access-token") String token, HttpServletRequest request)
	{
		studentService.deleteStudService(sno);
	}
	
}
