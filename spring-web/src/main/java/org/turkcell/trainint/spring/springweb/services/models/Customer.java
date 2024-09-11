package org.turkcell.trainint.spring.springweb.services.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.turkcell.trainint.spring.springweb.configuration.Location;
import org.turkcell.trainint.spring.springweb.validation.CheckWords;

import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(initialValue = 1, name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
@Table(name = "my_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id")
    private Long     customerId;
    @Column(name = "customer_unique_id", length = 50, unique = true)
    private String   customerUniqueId;
    private String   name;
    private String   surname;
    @NotBlank
    private String   username;
    @NotBlank
    private String   password;
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Location location;
    private LocalDateTime localDateTime;

    @Transient
    private Location location;

    @Version
    private Long xyz;

    @PreUpdate
    public void preUpdate(){
        localDateTime = LocalDateTime.now();
    }

    @PrePersist
    @PreRemove
    public void pre(){
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    @PostLoad
    public void post(){
    }

}
