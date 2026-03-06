package se.lexicon.spring_boot_app.service;

import se.lexicon.spring_boot_app.dto.request.OrderRequest;
import se.lexicon.spring_boot_app.dto.response.OrderResponse;
import se.lexicon.spring_boot_app.entity.Order;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest request);
}
