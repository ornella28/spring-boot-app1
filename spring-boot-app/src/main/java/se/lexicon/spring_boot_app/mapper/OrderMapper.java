package se.lexicon.spring_boot_app.mapper;

import org.springframework.stereotype.Component;
import se.lexicon.spring_boot_app.dto.response.OrderItemResponse;
import se.lexicon.spring_boot_app.dto.response.OrderResponse;
import se.lexicon.spring_boot_app.entity.Customer;
import se.lexicon.spring_boot_app.entity.Order;
import se.lexicon.spring_boot_app.entity.OrderItem;
import se.lexicon.spring_boot_app.entity.OrderStatus;

import java.time.Instant;
import java.util.List;

@Component
public class OrderMapper {

    //Entity-> response DTO
    public OrderResponse toResponse(Order order) {
        if (order == null) {
            return null;
        }

        List<OrderItemResponse> itemResponses = order.getOrderItems().stream()
                .map(item -> new OrderItemResponse(
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getPriceAtPurchase()
                ))
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                order.getCustomer().getId(),
                itemResponses
        );

    }

    //Build Order entity using customer + OrderItems (provided by service)
    public Order toEntity(Customer customer, List<OrderItem> items){
        if (customer == null)
            throw new IllegalArgumentException("Customer is null");

        if (items == null ||  items.isEmpty())
            throw new IllegalArgumentException("ORDER MUST CONTAIN AT LEAST ONE ITEM");

        Order order = new Order();
        order.setOrderDate(Instant.now());
        order.setStatus(OrderStatus.CREATED);
        order.setCustomer(customer);

        //link both sides for FK order_id

        items.forEach( i -> i.setOrder(order));
        order.setOrderItems(items);

        return order;

    }
}
