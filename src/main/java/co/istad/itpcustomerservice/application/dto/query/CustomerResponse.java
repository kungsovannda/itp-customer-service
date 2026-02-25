package co.istad.itpcustomerservice.application.dto.query;

import co.istad.itpcustomerservice.domain.valueobject.*;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerResponse(
        UUID customerId,
        CustomerName name,
        CustomerEmail email,
        String phoneNumber,
        LocalDate dob,
        CustomerGender gender,
        Kyc kyc,
        Address address,
        Contact contact,
        CustomerSegmentResponse customerSegment

) {
}
