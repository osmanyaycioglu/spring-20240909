package org.turkcell.trainint.spring.springweb.event;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherCommand implements CommandLineRunner {

    private final MyEventPublisher eventPublisher;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Publishing event.....");
        eventPublisher.publishEvent("Ayağa kalkmak üzereyim");
    }
}
