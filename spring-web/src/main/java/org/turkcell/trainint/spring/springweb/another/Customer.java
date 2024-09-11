package org.turkcell.trainint.spring.springweb.another;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
public class Customer {
    private String name;
    private String surname;
    private Integer weight;
    private Integer height;

}
