package edu.charleston.cofc_web_forms.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.JsonNode;

import edu.charleston.cofc_web_forms.services.EthosService;

@Controller
public class MainController {

	private EthosService ethosService;

	@Autowired
	public MainController(EthosService ethosService) {
		this.ethosService = ethosService;
	}

	@GetMapping("/")
	public String home(Model model) {
		try {

			// print attributes of the first course
			JsonNode courses = ethosService.getResource("courses");
			model.addAttribute("courses", courses);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
			return "error";
		}
	}

	@GetMapping("/error")
	public String error(Model model) {
		model.addAttribute("errorMessage", "An error occurred while processing your request.");

		return "error";
	}

}
