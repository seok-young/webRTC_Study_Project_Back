package com.example.webmedia_study_back.model.message;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPublishedChangeReportMessage {
    private boolean published;

}
