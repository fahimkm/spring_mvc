package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

		@GetMapping("/")
		public String homepage(Model model) {
			model.addAttribute("messages","Welcome to Spring MVC");
			return "index";
		}
}
