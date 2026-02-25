package co.istad.itpcustomerservice.domain.event;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.domain.valueobject.*;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.List;

@Builder
public record CustomerCreatedEvent(

        @TargetAggregateIdentifier
        CustomerId customerId,

        CustomerName name,

        CustomerEmail email,

        String phoneNumber,

        CustomerGender gender,

        LocalDate dob,

        Kyc kyc,

        Address address,

        Contact contact,

        CustomerSegmentId customerSegmentId) {
}
