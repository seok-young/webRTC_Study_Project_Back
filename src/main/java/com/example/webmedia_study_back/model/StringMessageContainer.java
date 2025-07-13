package com.example.webmedia_study_back.model;

import com.example.webmedia_study_back.service.JsonStringMessageDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 어플리케이션 프로토콜
// 클라이언트 -> 서버
public class StringMessageContainer {
    // 헤더
    private String roomId;
    private String from;
    private String to;
    private MessageType type;
    private String messageId;

    // 바디
    @JsonDeserialize(using = JsonStringMessageDeserializer.class)
    private String message;
    
}
