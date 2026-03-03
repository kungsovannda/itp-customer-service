package co.istad.itpcustomerservice.application.projection;

import java.util.UUID;

public record GetCustomerByIdQuery(
        UUID customerId
) {
}
