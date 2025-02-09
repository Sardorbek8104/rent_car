package pdp.uz.rentcar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pdp.uz.rentcar.entity.enums.PaymentStatus;
import pdp.uz.rentcar.entity.enums.PaymentType;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;


}
