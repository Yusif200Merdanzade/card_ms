package az.company.cardms.repository;

import az.company.cardms.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card>  findAllByUserIdAndStatus(Long userId,Character status);

    Card findByIdAndStatus(Long id, Character status);
}
