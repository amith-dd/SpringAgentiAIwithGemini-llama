package com.example.demo.service;

import org.springframework.stereotype.Service;

import dev.langchain4j.service.SystemMessage;


// converted from class to interface (for demonstration purposes)
@Service
public interface SalaryAiService {
	
	@SystemMessage("""
	        You are an AI assistant for an Employee Management System.
	        You have access to tools to fetch employee data and salary details.
	        Use them whenever needed to answer the user's question.
	        return the precise answer based on the data you get from the tools.
	        If the question is not related to employee salaries or profiles, respond with:
	        "I'm sorry, I can only assist with employee salary and profile related queries."
	        respond the tool response in JSON format only.
	        you can include your custom messages if needed.
	        """)
	    String chat(String question);
	

//	@Autowired
//	private ChatLanguageModel chatLanguageModel;
//	
//	public SalaryQueryIntent determineIntent(String question) {
//		String prompt = String.format(
//				"""
//						Determine the intent of the following salary-related question 
//						Return ONLY ONE WORD from this list, nothing else:
//				        Choose from the following intents: NET_SALARY, GROSS_SALARY, SALARY, PROFILE_DATA, PROFILE, ACTIVE_PROFILE, SUM_SALARY_BY_DEPARTMENT, MAX_SALARY_BY_DEPARTMENT. 
//				        Question: \"%s\"
//				        Respond with only the intent name, Do not add punctuation. Do not add explanation.
//				        """,
//				        question);
//		
//		Response<AiMessage> responseObj = chatLanguageModel.generate(UserMessage.from(prompt));
//		String response = responseObj.content().text().trim();
//		String cleaned = response
//		        .replaceAll("[^A-Z_]", "")
//		        .trim()
//		        .toUpperCase();
// 
//		try {
//			return SalaryQueryIntent.valueOf(cleaned);
//		} catch (IllegalArgumentException e) {
//			throw new RuntimeException("Unable to determine intent from response: " + response);
//		}
//		
//	}
	
}
