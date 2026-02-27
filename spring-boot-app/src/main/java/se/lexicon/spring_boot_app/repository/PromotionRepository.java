package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.spring_boot_app.entity.Promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // find promotions that are active on a given date


    @Query("""
SELECT p FROM Promotion p WHERE p.startDate <= :date AND (p.endDate IS NULL OR p.endDate >= :date)

""")

    List<Promotion> findActiveOn(@Param("date") LocalDate date);

    //Optional part

    Optional<Promotion> findByCodeIgnoreCase(String code);

    List<Promotion> findByStartDateAfter(LocalDate date);

    List<Promotion> findByEndDateBefore(LocalDate date);

    List<Promotion> findByEndDateIsNull();

    //find promotions active today
    @Query("""

SELECT p FROM Promotion p WHERE p.startDate <= CURRENT_DATE AND (p.endDate IS NULL OR p.endDate >= CURRENT_DATE)

""")

    List<Promotion> findActiveToday();

}
