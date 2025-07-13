package com.example.webmedia_study_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.example.webmedia_study_back.model.MessageType;
import com.example.webmedia_study_back.model.ObjectMessageContainer;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageSender {
    private static final String FromValue="webmedia-ws";
    private static final String AllValue="all";
    private static final String NoTransactionMessageId = "none";

    private ObjectMapper objectMapper;

    @Autowired
    public MessageSender(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void sendTransactionMessage(WebSocketSession session,
                                       String roomId, String to, String messageId, MessageType type,
                                       Object message) throws Exception {
        final ObjectMessageContainer container = ObjectMessageContainer.builder()
                .roomId(roomId)
                .from(FromValue)
                .to(to)
                .type(type)
                .messageId(messageId)
                .message(message)
                .build();
        final String containerString = objectMapper.writeValueAsString(container);
        final TextMessage textMessage = new TextMessage(containerString);

        session.sendMessage(textMessage);
}

    public void sendEventMessage(WebSocketSession session, String roomId, MessageType type,
                                Object message) throws Exception{
        final ObjectMessageContainer container = ObjectMessageContainer.builder()
            .roomId(roomId)
            .from(roomId)
            .to(AllValue)
            .type(type)
            .messageId(NoTransactionMessageId)
            .message(message)
            .build();    
            
        final String containerString = objectMapper.writeValueAsString(container);
        final TextMessage textMessage = new TextMessage(containerString);

        session.sendMessage(textMessage);
}

    
}
