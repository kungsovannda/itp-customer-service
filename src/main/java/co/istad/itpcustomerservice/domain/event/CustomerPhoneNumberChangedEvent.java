package co.istad.itpcustomerservice.domain.event;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record CustomerPhoneNumberChangedEvent(
        @TargetAggregateIdentifier
        CustomerId customerId,
        String phoneNumber
) {
}
