package org.turkcell.trainint.spring.springweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.turkcell.trainint.spring.springweb.services.models.Customer;

import java.util.List;
import java.util.Optional;


public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerUniqueId(String cuuid);

    List<Customer> findBySurnameAndName(String surname,
                                        String name);

    List<Customer> findBySurnameAndNameOrderByUsername(String surname,
                                                       String name);

    @Query("select c from Customer c where c.surname=?1 and c.name=?2")
    List<Customer> searchSurAndName(String surname,
                                    String name);

    @Query("select c.username,c.password from Customer c where c.surname=?1 and c.name=?2")
    List<Object[]> searchSurAndName2(String surname,
                                     String name);


    @Query("select new org.turkcell.trainint.spring.springweb.data.CustomerCredential(c.username,c.password) from Customer c where c.surname=?1 and c.name=?2")
    List<CustomerCredential> searchSurAndName3(String surname,
                                               String name);

    @Query(value = "select * from my_customer c where c.surname=?1 and c.name=?2", nativeQuery = true)
    List<Customer> searchSurAndNameNative(String surname,
                                          String name);

}
