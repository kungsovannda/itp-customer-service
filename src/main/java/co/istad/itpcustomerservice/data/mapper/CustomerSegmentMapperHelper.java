package co.istad.itpcustomerservice.data.mapper;

import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.data.entity.CustomerSegmentEntity;
import co.istad.itpcustomerservice.data.repository.CustomerSegmentRepository;
import co.istad.itpcustomerservice.domain.valueobject.CustomerSegmentType;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class CustomerSegmentMapperHelper {

    private final CustomerSegmentRepository repo;

    @Named("toCustomerSegmentId")
    public CustomerSegmentId toCustomerSegmentId(final CustomerSegmentType customerSegmentType){
        return new CustomerSegmentId(
                repo.findCustomerSegmentEntitiesByCustomerSegmentType(customerSegmentType).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Segment not found.")
                ).getCustomerSegmentId()
        );
    }

}
