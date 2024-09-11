package org.turkcell.trainint.spring.springweb.customer.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnableResponse {
    private String note;
    private String customerId;
}
