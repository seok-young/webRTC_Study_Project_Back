package com.example.webmedia_study_back.model.message;

import com.example.webmedia_study_back.model.RoomUser;

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
public class JoinResponseMessage {
    private String apiUrl;
    private String streamUrl;
    private String roomId;
    private RoomUser user;
    private RoomUser anotherUser;
    

}
