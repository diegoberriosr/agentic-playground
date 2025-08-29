package com.agentic.playground.config.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class ActiveModel {
    @Value("${application.llm.provider}") private String appLlmProvider;

    Map<String, Class<?>> modelMap = Map.of(
            "openai", OpenAiChatModel.class,
            "gemini", GoogleAiGeminiChatModel.class);

    @Bean
    public ChatModel appChatModel(List<ChatModel> models) throws IllegalStateException {
        Class<?> activeModelClass = modelMap.get(appLlmProvider);

        if (activeModelClass == null) throw new IllegalStateException("No model class found for this provider: " + appLlmProvider + ". Check the app properties.");

        for (ChatModel model : models) {
            if (model.getClass().equals(activeModelClass)) return model;
        }

        throw new IllegalStateException("No implemented chat model found for this provider: " + appLlmProvider + ". Check your bean mappings.");
    }
}
