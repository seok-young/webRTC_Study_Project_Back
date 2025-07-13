package com.example.webmedia_study_back.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.webmedia_study_back.model.MessageType;
import com.example.webmedia_study_back.model.StringMessageContainer;
import com.example.webmedia_study_back.service.MessageSender;
import com.example.webmedia_study_back.service.RoomAgent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebMediaHandler extends TextWebSocketHandler{
    private final ObjectMapper objectMapper;
    private final MessageSender messageSender;

    // 동시성 문제
    private final Object lockObj;
    private final Map<String, RoomAgent> agentMap;

    public WebMediaHandler(ObjectMapper objectMapper, MessageSender messageSender){
        this.objectMapper = objectMapper;
        this.messageSender = messageSender;

        this.lockObj = new Object();
        this.agentMap = new HashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        log.debug("Connection established : sessionId={}", session.getId());
        
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        log.debug("Connection closed : sessionId={}, status={}", session.getId(), status);
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        final String payload = message.getPayload();

        try{
            final StringMessageContainer messageContainer=objectMapper.readValue(payload,  StringMessageContainer.class);
            RoomAgent agent = null;

            if(MessageType.JoinRequest.equals(messageContainer.getType())){
                final String roomId = messageContainer.getRoomId();
                synchronized(lockObj) {
                    if(agentMap.containsKey(roomId)) {
                        agent = agentMap.get(roomId);
                    } else {
                        agent = new RoomAgent(objectMapper, messageSender, roomId);
                        agentMap.put(roomId, agent);
                    }
                }
            } else {
                synchronized(lockObj) {
                    agent = agentMap.get(messageContainer.getRoomId());
                }
            }
            agent.handleMessage(session, messageContainer.getMessageId(), messageContainer.getType(), messageContainer.getMessage());
        } catch (Exception e){
            log.debug("handleTextMessage error", e);

            session.close(new CloseStatus(3000, "알수없는 에러"));
        }
    }
}
