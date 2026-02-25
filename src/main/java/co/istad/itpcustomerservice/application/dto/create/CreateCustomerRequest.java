package co.istad.itpcustomerservice.application.dto.create;

import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.domain.valueobject.*;

import java.time.LocalDate;

public record CreateCustomerRequest(
        CustomerName name,
        CustomerEmail email,
        String phoneNumber,
        LocalDate dob,
        CustomerGender gender,
        Kyc kyc,
        Address address,
        Contact contact,
        CustomerSegmentType customerSegmentType
) {
}
