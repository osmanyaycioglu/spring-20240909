package org.turkcell.trainint.spring.springweb.customer.rest.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.turkcell.trainint.spring.springweb.customer.rest.models.CustomerDto;
import org.turkcell.trainint.spring.springweb.services.models.Customer;

@Mapper
public interface ICustomerMapper {

    ICustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(CustomerDto c);

    CustomerDto toCustomerDto(Customer c);

}
