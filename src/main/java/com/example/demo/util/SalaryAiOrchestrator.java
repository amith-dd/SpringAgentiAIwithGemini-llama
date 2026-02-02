package com.example.demo.util;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.SalaryAiService;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

@Service
public class SalaryAiOrchestrator {
	
	@Autowired
	private AiTool aiTool;
	
	@Autowired
	private ChatLanguageModel chatLanguageModel;
	
	public String answer(String question) {
		SalaryAiService service = AiServices.builder(SalaryAiService.class)
				.chatLanguageModel(chatLanguageModel)
				.tools(aiTool)
				.build();
		return service.chat(question);
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	private static final List<String> DEPARTMENTS =
//            List.of("IT", "HR", "Operations", "Finance");
//	
//	public Object answer(int id,String question) {
//		SalaryQueryIntent intent = salaryAiService.determineIntent(question);
//		Object data = aiTool.getEmployeeData(id, intent, detectDepartment(question));
//		return data;
//		
//	}
//	
//	
//	
//	public static String detectDepartment(String input) {
//        String normalized = input.toLowerCase();
//
//        for (String dept : DEPARTMENTS) {
//            if (normalized.contains(dept.toLowerCase())) {
//                return dept;
//            }
//        }
//        return null; // or throw exception
//    }
	

	
	
}
