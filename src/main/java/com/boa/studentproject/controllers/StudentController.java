package com.boa.studentproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boa.studentproject.daos.StudentDao;
import com.boa.studentproject.models.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value = "/student", method= RequestMethod.GET)
	public String getStudentForm(Model model){
		model.addAttribute("stud", new Student());
		
		return "studentForm";
	}
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student s , Model model){
		sdao.addStudent(s);
		model.addAttribute("slist",sdao.getAllStudent());
		
		return "home";
		}
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String  deleteStud(@PathVariable("id") int id, Model model){
		sdao.deleteStudent(id);
		model.addAttribute("slist", sdao.getAllStudent());
	
	return "home";
	}
	
	@RequestMapping (value = "/{id}/edit", method = RequestMethod.GET)
	public String editStud(@PathVariable("id") int id, Model model) {
		model.addAttribute("stud", sdao.getAllStudent());
		return "editForm";
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.GET)
    public String updateStud (@ModelAttribute Student s, Model model){
		sdao.updateStudent(s);
		model.addAttribute("slist", sdao.getAllStudent());
		
		return "home";
				}
	
	

}
