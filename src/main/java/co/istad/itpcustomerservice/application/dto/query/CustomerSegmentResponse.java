package co.istad.itpcustomerservice.application.dto.query;

import co.istad.itpcustomerservice.domain.valueobject.CustomerSegmentType;

import java.util.UUID;

public record CustomerSegmentResponse(
        UUID customerSegmentId,
        CustomerSegmentType customerSegmentType
) {
}
