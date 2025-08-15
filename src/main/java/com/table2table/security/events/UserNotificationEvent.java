package com.table2table.security.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotificationEvent {
    private Long userId;
    private String message;
    private LocalDateTime time;
}
