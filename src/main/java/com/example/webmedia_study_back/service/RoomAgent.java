package com.example.webmedia_study_back.service;

import org.springframework.web.socket.WebSocketSession;

import com.example.webmedia_study_back.model.MessageType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoomAgent {
    public RoomAgent(ObjectMapper objectMapper, MessageSender messageSender, String roomId) {

    }
    
    public String getRoomId(){
        return null;
    }

    public int getUserCount(){
        return 0;
    }

    public void handleUserLeft(WebSocketSession session) throws Exception {
        
    }
    
    public void handleMessage(WebSocketSession session, 
                              String messageId, MessageType type, String messageStr) throws Exception{

    }
    
}
