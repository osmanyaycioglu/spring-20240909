package org.turkcell.trainint.spring.springweb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.turkcell.trainint.spring.springweb.data.CustomerDao;
import org.turkcell.trainint.spring.springweb.data.ICustomerRepository;
import org.turkcell.trainint.spring.springweb.services.models.Customer;

@Service
@RequiredArgsConstructor
public class CustomerProvisionService {
    private final CustomerDao customerDao;

    public void enableCustomer(Customer customerParam){
        customerDao.insert(customerParam);
    }

    public void suspend(String customerId){
    }

    public void activate(String customerId){
    }
}
