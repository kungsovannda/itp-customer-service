package co.istad.itpcustomerservice.application;

import co.istad.itpcustomerservice.application.dto.query.CustomPageResponse;

public interface CustomerQueryService {

    CustomPageResponse getAllCustomers(int pageNumber, int pageSize);
}
