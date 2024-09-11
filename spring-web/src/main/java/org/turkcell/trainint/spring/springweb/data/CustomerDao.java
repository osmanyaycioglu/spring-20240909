package org.turkcell.trainint.spring.springweb.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.turkcell.trainint.spring.springweb.configuration.Location;
import org.turkcell.trainint.spring.springweb.services.models.Customer;

@Service
@RequiredArgsConstructor
public class CustomerDao {
    private final ICustomerRepository customerRepository;
    private final ILocationRepository locationRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void insert(Customer customerParam) {
        customerRepository.save(customerParam);
        Location locationLoc = customerParam.getLocation();
        locationLoc.setCustomerId(customerParam.getCustomerId());
        locationRepository.save(locationLoc);
        updateSomeInfo();
    }

    // @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateSomeInfo() {
        // Db de birşey update et
    }

    public void update(Customer customerParam) {
        customerRepository.save(customerParam);
    }

    public Customer get(Long customerId) {
        return customerRepository.findById(customerId)
                                 .orElse(null);
    }

    public Customer get(String customerUUID) {
        return customerRepository.findByCustomerUniqueId(customerUUID)
                                 .orElse(null);
    }

}
