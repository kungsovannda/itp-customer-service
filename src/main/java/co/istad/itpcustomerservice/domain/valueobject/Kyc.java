package co.istad.itpcustomerservice.domain.valueobject;

import java.util.UUID;

public record Kyc(
        UUID kycId,
        String type,
        String number

) {
}
