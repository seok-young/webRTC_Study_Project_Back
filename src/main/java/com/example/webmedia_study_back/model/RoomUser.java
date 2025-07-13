package com.example.webmedia_study_back.model;

import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomUser {
    private String roomId;
    private String userId;

    private boolean published;

    @JsonIgnore
    private WebSocketSession session;


}
