package se.lexicon.spring_boot_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.spring_boot_app.dto.request.CustomerRequest;
import se.lexicon.spring_boot_app.dto.response.CustomerResponse;
import se.lexicon.spring_boot_app.service.CustomerService;


@RestController// Spring mvc annotation, handles http request, returns json responses
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> register(@RequestBody @Valid CustomerRequest request){

        CustomerResponse response = customerService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @GetMapping("/{id}")// we are fetching data
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id){
        CustomerResponse response = customerService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody @Valid CustomerRequest request){
        CustomerResponse response = customerService.update(id, request);
        return ResponseEntity.ok(response);
    }




}
