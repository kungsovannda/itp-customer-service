package co.istad.itpcustomerservice.application.dto.update;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import lombok.Builder;

@Builder
public record ChangePhoneNumberResponse(
        CustomerId customerId,
        String phoneNumber,
        String message
) {
}
