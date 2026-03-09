package co.istad.itpcustomerservice.application.dto.create;

import co.istad.itpcustomerservice.domain.valueobject.*;

import java.time.LocalDate;

public record CreateCustomerRequest(
        co.istad.itpcommon.domain.valueobject.CustomerName name,
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
