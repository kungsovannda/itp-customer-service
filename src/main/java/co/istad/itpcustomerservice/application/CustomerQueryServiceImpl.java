package co.istad.itpcustomerservice.application;

import co.istad.itpcustomerservice.application.dto.query.CustomPageResponse;
import co.istad.itpcustomerservice.application.projection.GetCustomerQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService{

    private final QueryGateway queryGateway;

    @Override
    public CustomPageResponse getAllCustomers(int pageNumber, int pageSize){
        GetCustomerQuery getCustomerQuery = GetCustomerQuery.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .build();
        return queryGateway
                .query(getCustomerQuery, ResponseTypes.instanceOf(CustomPageResponse.class))
                .join();
    }
}
