package org.turkcell.trainint.spring.springweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turkcell.trainint.spring.springweb.configuration.Location;

public interface ILocationRepository extends JpaRepository<Location,Long> {
}
