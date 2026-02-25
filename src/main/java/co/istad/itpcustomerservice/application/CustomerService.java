package co.istad.itpcustomerservice.application;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerRequest;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerResponse;
import co.istad.itpcustomerservice.application.dto.update.ChangePhoneNumberRequest;
import co.istad.itpcustomerservice.application.dto.update.ChangePhoneNumberResponse;

public interface CustomerService {

    ChangePhoneNumberResponse changePhoneNumber(CustomerId customerId, ChangePhoneNumberRequest changePhoneNumberRequest);

    CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);
}
