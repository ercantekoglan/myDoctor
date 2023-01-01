package com.mydoctor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {
	
	
	//display index page
		@GetMapping("/index")
		public String getIndex(ModelMap model) {
				return "index";
			}
	
	//display Register page

		@GetMapping("/register")
		public String getRegister(ModelMap model) {
			return "/register";
		}
	
	
	//display Login page
	
		@GetMapping("/login")
		public String getLogin(ModelMap model) {
			return "/login";
		}
	
	//display Dashboard page
		
		@GetMapping("/dashboard")
		public String getDashboard(ModelMap model) {
			return "/dashboard";
		}	
		
	//display Profile page
		
		@GetMapping("/profile")
		public String getProfile(ModelMap model) {
			return "/profile";
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
