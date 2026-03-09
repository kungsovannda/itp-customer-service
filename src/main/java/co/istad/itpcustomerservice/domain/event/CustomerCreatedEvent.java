package co.istad.itpcustomerservice.domain.event;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.domain.valueobject.*;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Builder
public record CustomerCreatedEvent(

        @TargetAggregateIdentifier
        CustomerId customerId,

        co.istad.itpcommon.domain.valueobject.CustomerName name,

        CustomerEmail email,

        String phoneNumber,

        CustomerGender gender,

        LocalDate dob,

        Kyc kyc,

        Address address,

        Contact contact,

        CustomerSegmentId customerSegmentId) {
}
