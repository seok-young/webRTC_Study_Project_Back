package com.example.webmedia_study_back.model;

public enum MessageType {
    JoinRequest,

    JoinResponse,
    ErrorResponse,

    UserPublishedChangeReport,

    UserJoinedEvent,
    UserLeftEvent,
    UserStateChangedEvent;

}
