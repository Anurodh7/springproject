package com.boa.studentproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boa.studentproject.daos.UserDao;
import com.boa.studentproject.models.User;

@Controller
public class SignUpController {
	
	@Autowired
	private UserDao udao;
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String getSignUpForm(){
		
		return "signupForm";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)

	public String userSignup(@ModelAttribute User u){
		udao.signup(u);

		return "loginForm";
	}

}
