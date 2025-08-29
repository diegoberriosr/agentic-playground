package com.agentic.playground.resource;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ChatResource {
    private ChatModel appChatModel;

    public ChatResource(ChatModel appChatModel) {
        this.appChatModel = appChatModel;
    }

    @PostMapping
    public ResponseEntity<String> chat (@RequestBody String userMessage)  {
        String botResponse = appChatModel.chat(userMessage);
        return ResponseEntity.ok(botResponse);
    }
}
