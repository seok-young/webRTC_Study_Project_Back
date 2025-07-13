package com.example.webmedia_study_back.model.message;

import com.example.webmedia_study_back.model.ErrorCode;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponseMessage {
    private ErrorCode errorCode;
    private String message;

}
