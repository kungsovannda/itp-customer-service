package co.istad.itpcustomerservice.domain.command;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcustomerservice.domain.valueobject.Contact;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record ChangeCustomerPhoneNumberCommand(
        @TargetAggregateIdentifier
        CustomerId customerId,
        String phoneNumber
) {
}
