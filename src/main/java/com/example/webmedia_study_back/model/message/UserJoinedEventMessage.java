package com.example.webmedia_study_back.model.message;

import com.example.webmedia_study_back.model.RoomUser;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserJoinedEventMessage {
    private RoomUser user;
}
