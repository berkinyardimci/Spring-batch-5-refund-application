package com.springbatchapplication.util;

import com.springbatchapplication.entity.Customer;
import com.springbatchapplication.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        initializeCustomers();
    }

    private void initializeCustomers() {
        List<Customer> customers = Arrays.asList(
                Customer.builder().firstName("Dud").lastName("Ishak").balance(100.0).build(),
                Customer.builder().firstName("Ahmet").lastName("son").balance(150.0).build(),
                Customer.builder().firstName("Serkan").lastName("bahar").balance(200.0).build(),
                Customer.builder().firstName("Osaman").lastName("kıs").balance(75.0).build(),
                Customer.builder().firstName("Ali").lastName("yaz").balance(120.0).build(),
                Customer.builder().firstName("Mert").lastName("Aslan").balance(120.0).build(),
                Customer.builder().firstName("Mehmet").lastName("Koç").balance(180.0).build()
        );

        customerRepository.saveAll(customers);
    }
}
