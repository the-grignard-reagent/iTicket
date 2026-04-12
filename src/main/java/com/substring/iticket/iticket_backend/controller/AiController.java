package com.substring.iticket.iticket_backend.controller;


import com.substring.iticket.iticket_backend.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/iticket")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class AiController {

    private final AIService service;

    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(service.getResponseFromAssistant(query, conversationId));
    }

    @PostMapping("/stream")
    public Flux<String> streamResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.streamResponseFromAssistant(query, conversationId);
    }

}
