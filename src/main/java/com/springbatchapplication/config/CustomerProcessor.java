package com.springbatchapplication.config;

import com.springbatchapplication.entity.Customer;
import com.springbatchapplication.repository.CustomerRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer process(Customer customer){
        Long customerId = customer.getId();
        BigDecimal refundAmount = customer.getBalance();

        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            BigDecimal currentBalance = existingCustomer.getBalance();
            BigDecimal updatedBalance = currentBalance.add(refundAmount);
            existingCustomer.setBalance(updatedBalance);
        } else {
            System.out.println("Kullanıcı bulunamadı: " + customerId);
        }
        return existingCustomer;
    }
}
