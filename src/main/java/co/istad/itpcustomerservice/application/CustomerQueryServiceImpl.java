package co.istad.itpcustomerservice.application;

import co.istad.itpcustomerservice.application.dto.query.CustomPageResponse;
import co.istad.itpcustomerservice.application.dto.query.CustomerResponse;
import co.istad.itpcustomerservice.application.projection.GetCustomerByIdQuery;
import co.istad.itpcustomerservice.application.projection.GetCustomerQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService{

    private final QueryGateway queryGateway;
    private final EventStore eventStore;

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

    @Override
    public List<?> getCustomerHistory(UUID customerId) {
        return eventStore.readEvents(customerId.toString())
                .asStream()
                .map(Message::getPayload)
                .toList();
    }

    @Override
    public CustomerResponse getCustomerById(UUID customerId) {
        GetCustomerByIdQuery getCustomerByIdQuery = new GetCustomerByIdQuery(customerId);
        return queryGateway.query(getCustomerByIdQuery, ResponseTypes.instanceOf(CustomerResponse.class)).join();
    }
}
