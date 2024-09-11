package org.turkcell.trainint.spring.springweb.customer.rest.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.turkcell.trainint.spring.springweb.configuration.Location;
import org.turkcell.trainint.spring.springweb.validation.CheckWords;

@Data
@CheckWords({"abc","123","qwe"})
public class CustomerDto {
    @NotBlank
    private String name;
    private String surname;
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    @Valid
    @NotNull
    private Location location;
}
