package org.turkcell.trainint.spring.springweb.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCredential {

    private String username;
    private String password;

}
