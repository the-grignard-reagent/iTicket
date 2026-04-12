package com.substring.iticket.iticket_backend.config;


import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(AiConfig.class);

//    public jdbcChatMemoryRepository jdbcChatMemoryRepository(){
//        return jdbcChatMemoryRepository().builder().
//                jdbcTemplate().
//                build();
//    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository){

        var chatMemory = MessageWindowChatMemory.builder()
                        .chatMemoryRepository(jdbcChatMemoryRepository)
                        .maxMessages(10)
                        .build();

        logger.info("ChatClient has been created");
        logger.info("Chat memory bean created, {}", chatMemory.getClass().getName());

        return builder
                .defaultSystem("Summarize the response within 300 words.")
                .defaultAdvisors(new SimpleLoggerAdvisor(), MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }
}
