package com.example.webmedia_study_back.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

import com.example.webmedia_study_back.model.MessageType;
import com.example.webmedia_study_back.model.RoomUser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoomAgent {
    private static final int MaxUsers = 2;
    private static final String ApiUrl = "http://localhost:1985";
    private static final String StreamUrl = "webrtc://localhost";

    private final ObjectMapper objectMapper;
    private final MessageSender messageSender;
    private final String roomId;

    private final Object lockObj;
    private final Map<String, RoomUser> roomUserMap;
    private int userIdCounter;

    public RoomAgent(ObjectMapper objectMapper, MessageSender messageSender, String roomId) {
        this.objectMapper = objectMapper;
        this.messageSender = messageSender;
        this.roomId = roomId;

        this.lockObj = new Object();
        this.roomUserMap = new HashMap<>();
        this.userIdCounter = 0;
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
