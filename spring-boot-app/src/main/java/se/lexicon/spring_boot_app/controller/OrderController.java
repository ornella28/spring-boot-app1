package se.lexicon.spring_boot_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.spring_boot_app.dto.request.OrderRequest;
import se.lexicon.spring_boot_app.dto.response.OrderResponse;
import se.lexicon.spring_boot_app.service.CategoryService;
import se.lexicon.spring_boot_app.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody @Valid OrderRequest orderRequest) {

        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }
}
