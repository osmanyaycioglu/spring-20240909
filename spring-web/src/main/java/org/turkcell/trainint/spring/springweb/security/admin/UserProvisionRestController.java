package org.turkcell.trainint.spring.springweb.security.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.turkcell.trainint.spring.springweb.security.models.IInternalUserRepository;
import org.turkcell.trainint.spring.springweb.security.models.InternalUser;

import java.util.List;

@RestController
@RequestMapping("/admin/v1/user/provision")
@RequiredArgsConstructor
public class UserProvisionRestController {
    private final BCryptPasswordEncoder   passwordEncoder;
    private final IInternalUserRepository userRepository;

    @GetMapping("/add")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String role) {

        userRepository.save(InternalUser.builder()
                                        .withUsernameParam(username)
                                        .withPasswordParam(passwordEncoder.encode(password))
                                        .withRoleParam(role)
                                        .build());
        return "OK";
    }

    @GetMapping("/get/all")
    public List<InternalUser> getAllUsers() {
        return userRepository.findAll();
    }
}
