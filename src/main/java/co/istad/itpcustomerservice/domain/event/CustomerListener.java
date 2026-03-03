package co.istad.itpcustomerservice.domain.event;

import co.istad.itpcustomerservice.application.mapper.CustomerApplicationMapper;
import co.istad.itpcustomerservice.data.entity.CustomerEntity;
import co.istad.itpcustomerservice.data.entity.CustomerSegmentEntity;
import co.istad.itpcustomerservice.data.repository.CustomerRepository;
import co.istad.itpcustomerservice.data.repository.CustomerSegmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
@ProcessingGroup("customer-group")
public class CustomerListener {

    private final CustomerRepository customerRepository;
    private final CustomerApplicationMapper customerApplicationMapper;
    private final CustomerSegmentRepository customerSegmentRepository;

    @EventHandler
    public void on(CustomerCreatedEvent customerCreatedEvent){
        log.info("ON CustomerCreatedEvent: {}", customerCreatedEvent);

        UUID customerId = customerCreatedEvent.customerId().customerId();

        if (customerRepository.existsById(customerId)) {
            log.info("Customer already exists with id: {}, skipping save.", customerId);
            return;
        }

        CustomerEntity customerEntity = customerApplicationMapper.toCustomerEntity(customerCreatedEvent);

        customerEntity.getAddress().setCustomer(customerEntity);
        customerEntity.getContact().setCustomer(customerEntity);
        customerEntity.getKyc().setCustomer(customerEntity);

        customerEntity.setCustomerSegment(
                customerSegmentRepository.findById(customerCreatedEvent.customerSegmentId().customerSegmentId()).orElseThrow()
        );

//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "HELLO");

        log.info("Saved: {}", customerRepository.save(customerEntity));
    }

    @EventHandler(payloadType = CustomerPhoneNumberChangedEvent.class)
    public void on(CustomerPhoneNumberChangedEvent customerPhoneNumberChangedEvent){
        CustomerEntity customer = customerRepository.findById(customerPhoneNumberChangedEvent.customerId().customerId()).orElseThrow();
        customer.setPhoneNumber(customerPhoneNumberChangedEvent.phoneNumber());
        customerRepository.save(customer);
        log.info("ON CustomerPhoneNumberChangedEvent: {}", customerPhoneNumberChangedEvent);
    }
}
