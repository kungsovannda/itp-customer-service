package co.istad.itpcustomerservice.rest;

import co.istad.itpcommon.domain.dto.PageResponse;
import co.istad.itpcustomerservice.application.CustomerQueryService;
import co.istad.itpcustomerservice.application.dto.query.CustomPageResponse;
import co.istad.itpcustomerservice.application.dto.query.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerQueryController {

    private final CustomerQueryService customerQueryService;

    @GetMapping
    public PageResponse getAllCustomers(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "5", required = false) int pageSize
    ){
        return customerQueryService.getAllCustomers(pageNumber, pageSize).getPageResponse();
    }

    @GetMapping("/{customerId}/history")
    public List<?> getCustomerHistory(@PathVariable UUID customerId){
        return customerQueryService.getCustomerHistory(customerId);
    }

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomerById(@PathVariable UUID customerId){
        return customerQueryService.getCustomerById(customerId);
    }
}
