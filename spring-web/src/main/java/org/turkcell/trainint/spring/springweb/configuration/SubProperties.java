package org.turkcell.trainint.spring.springweb.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class SubProperties {
    private String innerName;
    private String anotherVersion;
    private Integer testCaseNumber;
    private Double successRatio;

}
