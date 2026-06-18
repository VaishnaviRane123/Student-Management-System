package edu.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.main.model.Student;
import edu.cjc.main.service.StudentService;

@Controller
public class AdminController {

	@Autowired
	StudentService ss;
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,Model m) {
		if(username.equals("admin") && password.equals("admin")) {
			List<Student>students=ss.getAllStudentDetails();
	m.addAttribute("data" ,students);
			return "adminscreen";
		}else {
			m.addAttribute("msg","invalid User ?");
		return "login";
	}
		
}
	@RequestMapping("enroll_student")
	public String saveStudent(@ModelAttribute Student student,Model m) {
	
		ss.saveStudentDetails(student);
		List<Student>students=ss.getAllStudentDetails();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,Model m) {
		
		List<Student>result=ss.searchStudentsByBatch(batchNumber);
		if(result.size()>0) {
			m.addAttribute("data",result);
		}else {
			List<Student>students=ss.getAllStudentDetails();
			m.addAttribute("data",students);
			m.addAttribute("message","No record are available for the batch"+batchNumber+"--!");
		}
		
		return "adminscreen";
	}
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam("studentId")int studentId,Model m) {
		ss.removeStudent(studentId);
		List<Student>list=ss.getAllStudentDetails();
		m.addAttribute("data",list);
		return "adminscreen";
	}
	
	@RequestMapping("/fees")
	public String onfees(@RequestParam("studentId")int studentId,Model m) {
		Student st=ss.getSingleStudent(studentId);
		m.addAttribute("st",st);
		return "fees";
	}
	@RequestMapping("/payfees")
	public String payfees(@RequestParam("studentId")int studentId,@RequestParam ("ammount")float ammount, Model m) {
		ss.updateStudentFees(studentId,ammount);
		List<Student>students=ss.getAllStudentDetails();
		m.addAttribute("data",students);
		return "adminscreen";
	}
	
	@RequestMapping("/batch")
	public String onShiftBatch(@RequestParam("studentId")int studentId,Model m) {
		Student st=ss.getSingleStudent(studentId);
		m.addAttribute("st",st);
		return "shiftbatch";
	}
	@RequestMapping("/updatebatch")
	public String updatebatch(@RequestParam("studentId")int studentId,@RequestParam("batchNumber")String batchNumber,Model m) {
		System.out.println("update");                                       
		ss.updatebatch(studentId,batchNumber);
		List<Student>students=ss.getAllStudentDetails();
		m.addAttribute("data",students);
		return "adminscreen";
	}
	
	
}

