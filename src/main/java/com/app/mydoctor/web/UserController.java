package com.app.mydoctor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.mydoctor.domain.User;
import com.app.mydoctor.dto.AddressDto;
import com.app.mydoctor.dto.PasswordDto;
import com.app.mydoctor.dto.PersonalInfoDto;
import com.app.mydoctor.dto.UserDto;
import com.app.mydoctor.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String welcomeRedirect() {
		return "redirect:/index";
	}
	//display index page
		@GetMapping("/index")
		public String getIndex(ModelMap model) {
			List<User> users = userService.findAll();
			model.put("users", users);
				return "/index";
			}
	
	//display Register page
		@GetMapping("/register")
		public String getCreateUser(ModelMap model) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
				model.put("user", new UserDto());
				return "register";
			}
			
			return "redirect:/login";
		}
	//create new User
		@PostMapping("/register")
		public String postRegister(UserDto userDto) {
				userService.saveUser(userDto);
			return "redirect:/login";
		}
	
	//display Login page
	
		@GetMapping("/login")
		public String getLogin(ModelMap model) {
			// to Prevent Authenticated Users From Accessing Login Page
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
				return "login";
			}
			return "/login";
			
		}
		
		@PostMapping("/login")
		public String postLogin(ModelMap model) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
				return "/index";
			}
			return "/dashboard";
		}
	
	//display Dashboard page
		
		@GetMapping("/dashboard")
		public String getDashboard(ModelMap model) {
			User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userService.findById(loggedInUser.getUserIdd());
			model.put("user", user);
			return "/dashboard";
		}	
		
	//update Profile page
		@PostMapping("/personal")
		@ResponseBody
		public String postProfile(@RequestBody PersonalInfoDto personalInfoDto) {
			User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userService.findById(loggedInUser.getUserIdd());
			userService.updatePersonalInfo(user,personalInfoDto);
			return "/dashboard";
		}
	//update Address Information page

		@PostMapping("/addressUpdate")
		@ResponseBody
		public String postAddress(@RequestBody AddressDto addressDto) {
			User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userService.findById(loggedInUser.getUserIdd());
			userService.updateAddress(user,addressDto);
			return "/dashboard";
		}
		
		//update Password Change page
		@PostMapping("/updatepassword")
		@ResponseBody
		public String postPassword(@RequestBody PasswordDto passwordDto) {
			User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			User user = userService.findById(loggedInUser.getUserIdd());
			userService.updatePassword(user,passwordDto);
			return "/dashboard";
		}
		
		
	//display Appointment page
		
		@GetMapping("/appointment")
		public String getAppointment(ModelMap model) {
			return "/appointment";
		}
	//display Messages page
		
		@GetMapping("/messages")
		public String getMessages(ModelMap model) {
			return "/messages";
		}
	//display Reports page
		
		@GetMapping("/reports")
		public String getReports(ModelMap model) {
			return "/reports";
		}
}
