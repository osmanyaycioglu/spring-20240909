package org.turkcell.trainint.spring.springweb.configuration;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long locationId;
    @NotBlank
    @Size(min = 3,max = 18)
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    private String district;

    @NotNull
    private Long customerId;
}
