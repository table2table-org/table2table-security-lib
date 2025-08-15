package com.table2table.security.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodStatusEvent {
    private Long foodPostId;
    private String status;       // e.g., RESERVED, CLAIMED
    private LocalDateTime time;
}
