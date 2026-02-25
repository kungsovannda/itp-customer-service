package co.istad.itpcustomerservice.data.init;

import co.istad.itpcustomerservice.data.entity.CustomerSegmentEntity;
import co.istad.itpcustomerservice.data.repository.CustomerSegmentRepository;
import co.istad.itpcustomerservice.domain.valueobject.CustomerSegmentType;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerSegmentInit {

    private final CustomerSegmentRepository repo;

    @PostConstruct
    public void init(){
        if(repo.count() == 0){
            CustomerSegmentEntity member = new CustomerSegmentEntity();
            member.setCustomerSegmentType(CustomerSegmentType.MEMBER);

            CustomerSegmentEntity vip = new CustomerSegmentEntity();
            vip.setCustomerSegmentType(CustomerSegmentType.VIP);

            repo.saveAll(List.of(member, vip));
        }
    }
}
