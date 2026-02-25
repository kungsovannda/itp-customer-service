package co.istad.itpcustomerservice.data.entity;

import co.istad.itpcustomerservice.domain.valueobject.CustomerEmail;
import co.istad.itpcustomerservice.domain.valueobject.CustomerGender;
import co.istad.itpcustomerservice.domain.valueobject.CustomerName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(name = "customers")
@Entity
public class CustomerEntity {

    @Id
    private UUID customerId;

    @Embedded
    private CustomerName name;

    @Embedded
    private CustomerEmail email;

    private LocalDate dob;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private CustomerGender gender;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private KycEntity kyc;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private AddressEntity address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private ContactEntity contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_segment_id")
    private CustomerSegmentEntity customerSegment;

    private List<String> failureMessages;
}
