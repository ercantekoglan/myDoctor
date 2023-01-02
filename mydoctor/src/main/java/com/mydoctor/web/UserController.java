package com.mydoctor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mydoctor.dto.UserDto;



@Controller
public class UserController {
	
	@GetMapping("")
	public String welcomeRedirect() {
		return "redirect:/index";
	}
	//display index page
		@GetMapping("/index")
		public String getIndex(ModelMap model) {
				return "/index";
			}
	
	//display Register page

		@GetMapping("/register")
		public String getRegister(ModelMap model) {
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//			if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//				return "register";
//			}
//			return "redirect:/";
			return "/register";
		}
	//create new User
		@PostMapping("/register")
		public String postRegister(@RequestBody UserDto userDto) {
			System.out.println(userDto);
			System.out.println("asd");

			return "redirect:/index";
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
	//display Address Information page
		
		@GetMapping("/profile/address-information")
		public String getAddressInformation(ModelMap model) {
			return "/profile-address";
		}	
		
		//display Password Change page
		
		@GetMapping("/profile/change-password")
		public String getPasswordInformation(ModelMap model) {
			return "/profile-password";
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
