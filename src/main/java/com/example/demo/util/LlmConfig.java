package com.example.demo.util;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import okhttp3.OkHttpClient;

@Configuration
public class LlmConfig {

	
	@Value("${gemini.api.key}")
	private String googleApiKey ;

	
	@Bean
	public ChatLanguageModel chatLanguageModel() {
		return  GoogleAiGeminiChatModel.builder()
			    .apiKey(googleApiKey)
			    .modelName("gemini-3-flash-preview") // You can change to other available Gemini models
			    .timeout(Duration.ofSeconds(180))  // 🔥 important
			    .temperature(0.8)
			    .build();
	}
	
//	 @Bean
//	    public OkHttpClient okHttpClient() {
//	        return new OkHttpClient.Builder()
//	                .connectTimeout(Duration.ofSeconds(30))
//	                .readTimeout(Duration.ofSeconds(180))   // 🔥 important
//	                .writeTimeout(Duration.ofSeconds(180))
//	                .build();
//	    }
	
}
