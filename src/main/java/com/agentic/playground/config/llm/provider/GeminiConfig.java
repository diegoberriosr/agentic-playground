package com.agentic.playground.config.llm.provider;

import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {
    @Value("${langchain4j.google-ai-gemini.chat-model.api-key}") private String geminiApiKey;
    @Value("${langchain4j.google-ai-gemini.chat-model.model-name}") private String geminiModelName;

    @Bean
    public GoogleAiGeminiChatModel geminiModel() {
        if (geminiApiKey == null || geminiApiKey.isEmpty()) throw new IllegalStateException("Gemini API key canot be null/empty");

        return GoogleAiGeminiChatModel
                .builder()
                .apiKey(geminiApiKey)
                .modelName(geminiModelName)
                .temperature(0.0)
                .build();
    }
}
