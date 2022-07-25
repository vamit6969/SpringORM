package com.yash.springorm3.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.springorm3.models.Student;
import com.yash.springorm3.models.Teacher;
import com.yash.springorm3.service.SpringOrmService;

//import com.yash.ServiceImpl.OperationServiceImpl;
//import com.yash.springorm3.models.Student;
//import com.yash.springorm3.models.StudentTestAttempt;
//import com.yash.springorm3.models.Teacher;
//import com.yash.springorm3.models.Test;
//import com.yash.springorm3.models.TestQuestions;
//import com.yash.services.OperationService;

@RestController
public class MyController {
	
	@Autowired
	private SpringOrmService service;
	
	//Write query to print total number of questions given by each teachers
	@GetMapping("/totalNumberOfQuestionByTeacher")
	public Map<String,Integer> totalNumberOfQuestionByTeacher()
	{
		System.out.println("abcd");
		Map<String,Integer> questionByTeacher=service.getCountQuestionByTeacher();
	 	return questionByTeacher;
	}
	
	//Write query to print teacher name total number of test created
	@GetMapping("/numberOfTestByTeacher")
	public Map<String,Integer> getTeacherWithTotalNumberOftest()
	{
		return service.getTeacherWithTotalNumberOftest();
	}
	
	//Write query to print student total marks obtained for each test for given student name
	@GetMapping("/getTotalMarksByStudentName/{name}")
	public Map<String, Double> getTotalMarksByStudentName(@PathVariable String name)
	{
		return service.getTotalMarksByStudentName(name);
		
	}
	
	//Write query to print result of students for teacher by teacher name
	@GetMapping("/getResultOfAllStudentByTeacherName")
	public Map<String,Map<String,Map<String,Double>>> getResultOfAllStudentByTeacherName()
	{
		return service.getResultOfStudentByTeacherName();
	}
	
	//Count how many test is given by a student
	@GetMapping("/getCountOfTestGivenByStudent")
	public Map<Student,Integer> getCountOfTestGivenByStudent()
	{
		return service.getCountOfTestGivenByAllStudent();

	}
	
	//Calculate average wrong questions attempt by students.
	@GetMapping("/getAverageOfWrongAnswerByStudent")
	public double getAverageOfWrongAnswerByStudent()
	{
		return service.getCountOfWrongAnswerByStudent();
	}
	
	//Calculate average correct questions attempt by students
	@GetMapping("/getAverageOfCorrectAnswerByStudent")
	public double getAverageOfCorrectAnswerByStudent()
	{
		return service.getCountOfCorrectAnswerByStudent();
	}
}
