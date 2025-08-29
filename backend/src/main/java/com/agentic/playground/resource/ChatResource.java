package com.agentic.playground.resource;

import dev.langchain4j.agentic.UntypedAgent;
import dev.langchain4j.model.chat.ChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ChatResource {
    private ChatModel appChatModel;
    private UntypedAgent sequentialAgent;

    public ChatResource(ChatModel appChatModel, UntypedAgent sequentialAgent) {
        this.appChatModel = appChatModel;
        this.sequentialAgent = sequentialAgent;
    }

    @PostMapping
    public ResponseEntity<String> chat (@RequestBody String userMessage)  {
        String botResponse = appChatModel.chat(userMessage);
        return ResponseEntity.ok(botResponse);
    }


    @PostMapping("/sequential")
    public ResponseEntity<String> sequentialChat(@RequestBody String topic)  {
        String botResponse = (String) sequentialAgent.invoke(Map.of(
                "topic", topic));

        return ResponseEntity.ok(botResponse);
    }
}
