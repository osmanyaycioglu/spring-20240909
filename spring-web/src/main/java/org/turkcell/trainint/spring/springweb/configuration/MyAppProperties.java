package org.turkcell.trainint.spring.springweb.configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "my.app.props")
@Data
@Validated
public class MyAppProperties {
    private String name;
    @NotBlank
    private String version;
    private Integer test;
    private Double multiplier;
    // ContactPhones -> pascal
    // contactPhones -> camel
    // contact_phones -> snake
    // contact-phones -> kebap
    private List<String> contactPhones;
    @NestedConfigurationProperty
    private SubProperties subProperties;
    private List<Location> locations;
    private Map<String,Location> specificLocations;

}
