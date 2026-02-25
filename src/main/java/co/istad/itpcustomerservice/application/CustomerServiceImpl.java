package co.istad.itpcustomerservice.application;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerRequest;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerResponse;
import co.istad.itpcustomerservice.application.dto.update.ChangePhoneNumberRequest;
import co.istad.itpcustomerservice.application.dto.update.ChangePhoneNumberResponse;
import co.istad.itpcustomerservice.application.mapper.CustomerApplicationMapper;
import co.istad.itpcustomerservice.domain.command.ChangeCustomerPhoneNumberCommand;
import co.istad.itpcustomerservice.domain.command.CreateCustomerCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerApplicationMapper mapper;
    private final CommandGateway commandGateway;


    @Override
    public ChangePhoneNumberResponse changePhoneNumber(CustomerId customerId, ChangePhoneNumberRequest changePhoneNumberRequest) {

        ChangeCustomerPhoneNumberCommand changeCustomerPhoneNumberCommand = ChangeCustomerPhoneNumberCommand
                .builder()
                .customerId(customerId)
                .phoneNumber(changePhoneNumberRequest.phoneNumber())
                .build();

        CustomerId result = commandGateway.sendAndWait(changeCustomerPhoneNumberCommand);

        return ChangePhoneNumberResponse.builder()
                .customerId(result)
                .message("Phone number changed successfully")
                .phoneNumber(changePhoneNumberRequest.phoneNumber())
                .build();
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {

        CreateCustomerCommand createCustomerCommand =  mapper.toCreateCustomerCommand(
                new CustomerId(UUID.randomUUID()),
                createCustomerRequest
        );

        CustomerId result = commandGateway.sendAndWait(createCustomerCommand);

        return CreateCustomerResponse.builder()
                .customerId(result)
                .message("Customer created successfully")
                .build();
    }
}
