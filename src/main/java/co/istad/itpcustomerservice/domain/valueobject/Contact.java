package co.istad.itpcustomerservice.domain.valueobject;

import java.util.UUID;

public record Contact(
        UUID contactId,
        String type,
        String number
) {
}
