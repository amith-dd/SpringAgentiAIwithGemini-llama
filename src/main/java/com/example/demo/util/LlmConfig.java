package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

@Configuration
public class LlmConfig {
	
	@Value("${gemini.api.key}")
	private String googleApiKey ;
	
	@Bean
	public ChatLanguageModel chatLanguageModel() {
		return  GoogleAiGeminiChatModel.builder()
			    .apiKey(googleApiKey)
			    .modelName("gemini-3-flash-preview") // You can change to other available Gemini models
			    .temperature(0.8)
			    .build();
	}
	
}
