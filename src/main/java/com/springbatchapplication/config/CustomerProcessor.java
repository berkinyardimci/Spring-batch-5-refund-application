package com.springbatchapplication.config;

import com.springbatchapplication.entity.Customer;
import com.springbatchapplication.repository.CustomerRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer process(Customer item) throws Exception {
        Long customerId = item.getId();
        double refundAmount = item.getBalance();

        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            double currentBalance = existingCustomer.getBalance();
            double updatedBalance = currentBalance + refundAmount;
            existingCustomer.setBalance(updatedBalance);

        } else {
            System.out.println("Kullanıcı bulunamadı: " + customerId);
        }
        return existingCustomer;
    }
}
