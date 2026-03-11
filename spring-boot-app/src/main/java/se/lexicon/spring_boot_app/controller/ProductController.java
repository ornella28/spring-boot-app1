package se.lexicon.spring_boot_app.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.spring_boot_app.dto.request.ProductRequest;
import se.lexicon.spring_boot_app.dto.response.ProductResponse;
import se.lexicon.spring_boot_app.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request){
        ProductResponse productResponse = productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<ProductResponse> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
   public ResponseEntity<List<ProductResponse>> findByName(@RequestParam String name){
        List<ProductResponse> products = productService.searchByName(name);
        return ResponseEntity.ok(products);
    }
}
