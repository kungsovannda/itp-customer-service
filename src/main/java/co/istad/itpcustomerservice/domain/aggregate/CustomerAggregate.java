package co.istad.itpcustomerservice.domain.aggregate;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.domain.command.ChangeCustomerPhoneNumberCommand;
import co.istad.itpcustomerservice.domain.command.CreateCustomerCommand;
import co.istad.itpcustomerservice.domain.event.CustomerCreatedEvent;
import co.istad.itpcustomerservice.domain.event.CustomerPhoneNumberChangedEvent;
import co.istad.itpcustomerservice.domain.valueobject.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;
import java.util.List;

@Aggregate(snapshotTriggerDefinition = "customSnapshotTriggerDefinition")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class CustomerAggregate {

    @AggregateIdentifier
    @TargetAggregateIdentifier
    private CustomerId customerId;

    private co.istad.itpcommon.domain.valueobject.CustomerName name;

    private CustomerEmail email;

    private String phoneNumber;

    private CustomerGender gender;

    private LocalDate dob;

    private Kyc kyc;

    private Address address;

    private Contact contact;

    private CustomerSegmentId customerSegmentId;

    private List<String> failureMessages;

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand createCustomerCommand){
        CustomerCreatedEvent customerCreatedEvent = CustomerCreatedEvent.builder()
                .customerId(createCustomerCommand.customerId())
                .name(createCustomerCommand.name())
                .email(createCustomerCommand.email())
                .phoneNumber(createCustomerCommand.phoneNumber())
                .gender(createCustomerCommand.gender())
                .dob(createCustomerCommand.dob())
                .kyc(createCustomerCommand.kyc())
                .address(createCustomerCommand.address())
                .contact(createCustomerCommand.contact())
                .customerSegmentId(createCustomerCommand.customerSegmentId())
                .build();

        AggregateLifecycle.apply(customerCreatedEvent);
    }

    @CommandHandler
    public CustomerId handle(ChangeCustomerPhoneNumberCommand changeCustomerPhoneNumberCommand){
        CustomerPhoneNumberChangedEvent customerPhoneNumberChangedEvent = CustomerPhoneNumberChangedEvent
                .builder()
                .customerId(changeCustomerPhoneNumberCommand.customerId())
                .phoneNumber(changeCustomerPhoneNumberCommand.phoneNumber())
                .build();
        AggregateLifecycle.apply(customerPhoneNumberChangedEvent);
        return this.customerId;
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent customerCreatedEvent){
        this.customerId = customerCreatedEvent.customerId();
        this.name = customerCreatedEvent.name();
        this.email = customerCreatedEvent.email();
        this.phoneNumber = customerCreatedEvent.phoneNumber();
        this.gender = customerCreatedEvent.gender();
        this.dob = customerCreatedEvent.dob();
        this.kyc = customerCreatedEvent.kyc();
        this.address = customerCreatedEvent.address();
        this.contact = customerCreatedEvent.contact();
        this.customerSegmentId = customerCreatedEvent.customerSegmentId();
    }

    @EventSourcingHandler
    public void handle(CustomerPhoneNumberChangedEvent customerPhoneNumberChangedEvent){
        this.customerId = customerPhoneNumberChangedEvent.customerId();
        this.phoneNumber = customerPhoneNumberChangedEvent.phoneNumber();
    }


}
