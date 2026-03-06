package se.lexicon.spring_boot_app.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lexicon.spring_boot_app.dto.request.OrderItemRequest;
import se.lexicon.spring_boot_app.dto.request.OrderRequest;
import se.lexicon.spring_boot_app.dto.response.OrderResponse;
import se.lexicon.spring_boot_app.entity.Customer;
import se.lexicon.spring_boot_app.entity.Order;
import se.lexicon.spring_boot_app.entity.OrderItem;
import se.lexicon.spring_boot_app.entity.Product;
import se.lexicon.spring_boot_app.mapper.OrderMapper;
import se.lexicon.spring_boot_app.repository.CustomerRepository;
import se.lexicon.spring_boot_app.repository.OrderRepository;
import se.lexicon.spring_boot_app.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest request){

        //Find customer
        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(()-> new RuntimeException("Customer Not Found"));

        //Build order items

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemRequest : request.items()){
            Product product = productRepository.findById(itemRequest.id())
                    .orElseThrow(()-> new RuntimeException("Product Not Found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.quantity());
            orderItem.setPriceAtPurchase(product.getPrice());

            orderItems.add(orderItem);
        }

        //build order entity using mapper
        Order order = orderMapper.toEntity(customer, orderItems);

        //Save order

        Order savedOrder = orderRepository.save(order);

        //Return response DTO
        return orderMapper.toResponse(savedOrder);

    }


}
