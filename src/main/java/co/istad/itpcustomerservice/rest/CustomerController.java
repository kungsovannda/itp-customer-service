package co.istad.itpcustomerservice.rest;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcustomerservice.application.CustomerService;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerRequest;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerResponse;
import co.istad.itpcustomerservice.application.dto.update.ChangePhoneNumberRequest;
import co.istad.itpcustomerservice.application.dto.update.ChangePhoneNumberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return  customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping("/{customerId}")
    public ChangePhoneNumberResponse changePhoneNumber(@PathVariable UUID customerId, @RequestBody ChangePhoneNumberRequest changePhoneNumberRequest){
        return customerService.changePhoneNumber(
                new CustomerId(customerId),
                changePhoneNumberRequest
        );
    }

}
