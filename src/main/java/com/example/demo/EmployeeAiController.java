package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.SalaryAiOrchestrator;

@RestController
@RequestMapping("/employee-ai")
public class EmployeeAiController {
		
	@Autowired
	private SalaryAiOrchestrator aiOrchestrator;
	
	@GetMapping("/answer")
	public Object answer(@RequestBody String question) {
		return aiOrchestrator.answer( question);
	}
	
}
