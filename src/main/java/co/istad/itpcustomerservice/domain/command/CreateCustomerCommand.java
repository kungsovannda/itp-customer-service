package co.istad.itpcustomerservice.domain.command;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.domain.valueobject.*;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Builder
public record CreateCustomerCommand(

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

        CustomerSegmentId customerSegmentId
) {
}
