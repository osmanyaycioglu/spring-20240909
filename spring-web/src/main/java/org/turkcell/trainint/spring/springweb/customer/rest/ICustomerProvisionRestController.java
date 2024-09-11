package org.turkcell.trainint.spring.springweb.customer.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.turkcell.trainint.spring.springweb.customer.rest.models.CustomerDto;
import org.turkcell.trainint.spring.springweb.customer.rest.models.EnableResponse;

@RequestMapping("/api/v1/customer/provision")
public interface ICustomerProvisionRestController {
    @PostMapping("/enable")
    @Operation(summary = "Müşteriyi sisteme ekleme",
            description = "Müşteri bilgileri database e yazılacak HLR da açılacak", responses = {
            @ApiResponse(responseCode = "200", description = "Bunu döndüğümde oluşur"),
            @ApiResponse(responseCode = "400", description = "ErrorObj döneceğim")
    })
    ResponseEntity<EnableResponse> enable(@RequestBody CustomerDto customerDtoParam);


    @GetMapping("/suspend")
    String suspend(@RequestParam String customerId);

    @GetMapping("/activate")
    String activate(@RequestParam String customerId);
}
