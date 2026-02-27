package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.Order;
import se.lexicon.spring_boot_app.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer_Id(Long customerId);

    @EntityGraph(attributePaths = {"orderItems"})// to avoid N+1
    List<Order> findByStatus(OrderStatus status);

    //Optional part

    List<Order> findByOrderDateAfter(Instant date);
    List<Order> findByOrderDateBetween(Instant start, Instant end);
    List<Order> findDistinctByOrderItems_Product_Id(Long productId);
    long countByStatus(OrderStatus status);
    List<Order> findByCustomer_IdAndStatus(Long customerId, OrderStatus status);



}
