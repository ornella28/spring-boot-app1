package se.lexicon.spring_boot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.spring_boot_app.entity.Order;
import se.lexicon.spring_boot_app.entity.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder_Id(Long orderId);

    List<OrderItem> findByProduct_Id(Long productId);

    List<OrderItem> findByQuantityGreaterThan(int quantity);


}
