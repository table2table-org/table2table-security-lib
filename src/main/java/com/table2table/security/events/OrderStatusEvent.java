package com.table2table.security.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Event representing order status changes across services
 * Used by Food Service, Payment Service to update Order Service
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusEvent {

    private Long foodRequestId;
    private String status; // PENDING, RESERVED, ACCEPTED, REJECTED, REFUND_INITIATED
    private String rejectionReason;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    private String authHeader;

    public boolean isValid() {
        return foodRequestId != null &&
                status != null &&
                timestamp != null;
    }
}