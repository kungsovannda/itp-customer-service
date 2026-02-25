package co.istad.itpcustomerservice.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Table(name = "contacts")
@Entity
public class ContactEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID contactId;

    private String type;
    private String number;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
