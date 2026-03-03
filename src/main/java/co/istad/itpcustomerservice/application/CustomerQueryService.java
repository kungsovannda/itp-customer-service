package co.istad.itpcustomerservice.application;

import co.istad.itpcustomerservice.application.dto.query.CustomPageResponse;
import co.istad.itpcustomerservice.application.dto.query.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerQueryService {

    CustomPageResponse getAllCustomers(int pageNumber, int pageSize);
    List<?> getCustomerHistory(UUID customerId);
    CustomerResponse getCustomerById(UUID customerId);
}
