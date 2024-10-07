package org.turkcell.trainint.spring.springweb.services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InputService {

    private AtomicLong        counter  = new AtomicLong(0);
    private List<Long>        counters = new Vector<>();
    private List<Long>        counters2 = Collections.synchronizedList(new ArrayList<>());
    private Map<Long, String> map      = new ConcurrentHashMap<>();

    public long increase() {
        long lLoc = counter.incrementAndGet();
        counters.add(lLoc);
        return lLoc;
    }

}
