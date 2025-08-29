package com.agentic.playground.config.llm.provider;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {
    @Value("${langchain4j.open-ai.chat-model.api-key}") private String openAiApiKey;
    @Value("${langchain4j.open-ai.chat-model.model-name}") private String openAiModelName;

    @Bean
    public OpenAiChatModel openAiModel() throws IllegalStateException{
        if (openAiApiKey == null || openAiApiKey.isEmpty()) throw new IllegalStateException("Open AI api key canot be null/empty");

        return OpenAiChatModel
                .builder()
                .apiKey(openAiApiKey)
                .temperature(0.0)
                .modelName(openAiModelName)
                .build();
    }
}
