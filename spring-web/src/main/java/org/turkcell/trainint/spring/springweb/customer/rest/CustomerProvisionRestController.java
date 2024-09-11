package org.turkcell.trainint.spring.springweb.customer.rest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.turkcell.trainint.spring.springweb.customer.rest.mappings.ICustomerMapper;
import org.turkcell.trainint.spring.springweb.customer.rest.models.CustomerDto;
import org.turkcell.trainint.spring.springweb.customer.rest.models.EnableResponse;
import org.turkcell.trainint.spring.springweb.services.CustomerProvisionService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CustomerProvisionRestController implements ICustomerProvisionRestController {
    private final CustomerProvisionService customerProvisionService;
    private final ThreadLocal<String>      transId = new ThreadLocal<>() {
        @Override
        protected String initialValue() {
            return UUID.randomUUID()
                       .toString();
        }
    };

    public ResponseEntity<EnableResponse> enable(@Valid @RequestBody CustomerDto customerDtoParam) {
        customerProvisionService.enableCustomer(ICustomerMapper.CUSTOMER_MAPPER.toCustomer(customerDtoParam));

        return ResponseEntity.status(HttpStatus.OK)
                             .header("transId",
                                     transId.get())
                             .body(new EnableResponse("Müşteri sisteme tanıtıldı",
                                                      UUID.randomUUID()
                                                          .toString()));
    }

    public String suspend(@RequestParam String customerId) {
        return "OK";
    }

    public String activate(@RequestParam String customerId) {
        return "OK";
    }

}
