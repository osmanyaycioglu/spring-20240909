package org.turkcell.trainint.spring.springweb.security.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IInternalUserRepository extends JpaRepository<InternalUser,String> {
}
