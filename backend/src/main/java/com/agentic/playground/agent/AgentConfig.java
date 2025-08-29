package com.agentic.playground.agent;

import com.agentic.playground.agent.sequential.CreativeWriter;
import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.agentic.UntypedAgent;
import dev.langchain4j.model.chat.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgentConfig {
    private final ChatModel appChatModel;

    public AgentConfig(ChatModel appChatModel) {
        this.appChatModel = appChatModel;
    }

    @Bean
    public UntypedAgent sequentialAgent() {
        CreativeWriter writerAgent = AgenticServices
                .agentBuilder(CreativeWriter.class)
                .outputName("story")
                .chatModel(appChatModel)
                .build();

        return AgenticServices
                .sequenceBuilder()
                .subAgents(writerAgent)
                .outputName("story")
                .build();
    }
}
