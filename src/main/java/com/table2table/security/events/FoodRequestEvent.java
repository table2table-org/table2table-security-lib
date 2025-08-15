package com.table2table.security.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Event representing a food request from Order Service to Food Service
 * Includes all necessary information for inventory processing and validation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor // Required for Kafka JSON deserialization
public class FoodRequestEvent {

    private Long foodRequestId;
    private Long foodPostId;
    private Long requesterId;
    private Long cookId;
    private Integer requestedQuantity;
    private Integer availableQuantity;
    private String status; // PENDING, PROCESSING, etc.

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    private String authHeader;

    /**
     * Validation method to ensure event integrity
     */
    public boolean isValid() {
        return foodRequestId != null &&
                foodPostId != null &&
                requesterId != null &&
                cookId != null &&
                requestedQuantity != null &&
                requestedQuantity > 0 &&
                availableQuantity != null &&
                availableQuantity >= 0 &&
                status != null &&
                timestamp != null;
    }
}