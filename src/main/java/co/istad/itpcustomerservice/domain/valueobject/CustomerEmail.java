package co.istad.itpcustomerservice.domain.valueobject;

public record CustomerEmail(
        String primaryEmail,
        String secondaryEmail
) {
}
