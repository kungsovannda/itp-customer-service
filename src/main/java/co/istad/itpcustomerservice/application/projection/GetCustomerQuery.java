package co.istad.itpcustomerservice.application.projection;

import lombok.Builder;

@Builder
public record GetCustomerQuery(
        int pageSize,
        int pageNumber
) {

}
