package org.turkcell.trainint.spring.springweb.security.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class InternalUser {
    @Id
    private String username;
    private String password;
    private String role;

    public InternalUser() {
    }

    @Builder(setterPrefix = "with")
    public InternalUser(final String usernameParam,
                        final String passwordParam,
                        final String roleParam) {
        username = usernameParam;
        password = passwordParam;
        role     = roleParam;
    }
}
