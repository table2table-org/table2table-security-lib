package com.table2table.security.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Event representing payment status changes
 * Published by Order Service, consumed by other services needing payment info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEvent {

    private Long paymentId;
    private Long requestId;
    private Boolean successful;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public boolean isValid() {
        return paymentId != null &&
                requestId != null &&
                successful != null &&
                timestamp != null;
    }
}