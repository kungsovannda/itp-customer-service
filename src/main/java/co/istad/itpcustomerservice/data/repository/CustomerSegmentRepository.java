package co.istad.itpcustomerservice.data.repository;

import co.istad.itpcommon.domain.valueobject.CustomerSegmentId;
import co.istad.itpcustomerservice.data.entity.CustomerSegmentEntity;
import co.istad.itpcustomerservice.domain.valueobject.CustomerSegmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerSegmentRepository extends JpaRepository<CustomerSegmentEntity, UUID> {
    Optional<CustomerSegmentEntity> findCustomerSegmentEntitiesByCustomerSegmentType(CustomerSegmentType customerSegmentType);
}
