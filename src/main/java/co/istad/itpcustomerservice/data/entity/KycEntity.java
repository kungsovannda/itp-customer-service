package co.istad.itpcustomerservice.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Table(name = "kycs")
@Entity
public class KycEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID kycId;

    private String type;

    private String number;

    @OneToOne
    private CustomerEntity customer;
}
