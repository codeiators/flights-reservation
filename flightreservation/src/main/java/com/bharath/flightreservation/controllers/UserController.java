package com.bharath.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.entities.User;
import com.bharath.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage()
	{
		return "login/registerUser";
	}
	
	@RequestMapping(value="registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user)
	{
		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="/login")
	public String showLogin()
	{
		return "login/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("password") String password,ModelMap modelMap)
	{
		User user=userRepository.findByEmail(email);
		if(password.equals(user.getPassword()))
		{
			
			return "findFlights";
		}
		else
		{
			String msg="Invalid username or password.Please try again";
			modelMap.addAttribute("msg",msg);
		}
		
		return "login/login";
	}

}
