package co.istad.itpcustomerservice.application.mapper;

import co.istad.itpcommon.domain.valueobject.CustomerId;
import co.istad.itpcustomerservice.application.dto.create.CreateCustomerRequest;
import co.istad.itpcustomerservice.application.dto.query.CustomerResponse;
import co.istad.itpcustomerservice.data.entity.CustomerEntity;
import co.istad.itpcustomerservice.data.mapper.CustomerSegmentMapperHelper;
import co.istad.itpcustomerservice.domain.command.CreateCustomerCommand;
import co.istad.itpcustomerservice.domain.event.CustomerCreatedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {CustomerSegmentMapperHelper.class})
public interface CustomerApplicationMapper {

    @Mapping(source = "createCustomerRequest.customerSegmentType", target = "customerSegmentId", qualifiedByName = "toCustomerSegmentId")
    CreateCustomerCommand toCreateCustomerCommand(CustomerId customerId, CreateCustomerRequest createCustomerRequest);

    @Mapping(source = "customerCreatedEvent.customerId.customerId", target = "customerId")
    CustomerEntity toCustomerEntity(CustomerCreatedEvent customerCreatedEvent);

    CustomerResponse toCustomerResponse(CustomerEntity customerEntity);

    default CustomerId map(UUID value) {
        return new CustomerId(value);
    }
}
