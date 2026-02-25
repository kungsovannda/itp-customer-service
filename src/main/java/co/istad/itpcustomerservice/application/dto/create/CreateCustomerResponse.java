package co.istad.itpcustomerservice.application.dto.create;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import lombok.Builder;

@Builder
public record CreateCustomerResponse(
        CustomerId customerId,
        String message
) {
}
