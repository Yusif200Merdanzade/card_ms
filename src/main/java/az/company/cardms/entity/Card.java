package az.company.cardms.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "card", schema = "payment_system")
@Where(clause = "status <> '0'")
@SQLDelete(sql = "UPDATE payment_system.card SET status='0', update_date=CURRENT_TIMESTAMP WHERE id = ?")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "card_number")
    String cardNumber;

    @Column(name = "expiration_date")
    LocalDate expirationDate;

    String cvv;

    double balance;

    @Column(name = "user_id")
    Long userId;

    Character status = '1';

    @Column(name = "update_date")
    LocalDateTime updateDate;

}
