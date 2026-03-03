package co.istad.itpcustomerservice.application.projection;

import co.istad.itpcustomerservice.application.dto.query.CustomPageResponse;
import co.istad.itpcustomerservice.application.dto.query.CustomerResponse;
import co.istad.itpcustomerservice.application.mapper.CustomerApplicationMapper;
import co.istad.itpcustomerservice.data.entity.CustomerEntity;
import co.istad.itpcustomerservice.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerQueryHandler {

    private final CustomerRepository customerRepository;
    private final CustomerApplicationMapper applicationMapper;


    @QueryHandler
    public CustomPageResponse handle(GetCustomerQuery getCustomerQuery){
        Pageable pageRequest = PageRequest.of(getCustomerQuery.pageNumber(),  getCustomerQuery.pageSize(), Sort.by(Sort.Direction.DESC, "dob"));
        Page<CustomerEntity> customerEntities = customerRepository.findAll(pageRequest);
        return new CustomPageResponse(customerEntities.map(
                applicationMapper::toCustomerResponse
        ));
    }

    @QueryHandler
    public CustomerResponse handle(GetCustomerByIdQuery getCustomerByIdQuery){
        CustomerEntity customer = customerRepository.findById(getCustomerByIdQuery.customerId()).orElse(null);
        return applicationMapper.toCustomerResponse(customer);
    }
}
