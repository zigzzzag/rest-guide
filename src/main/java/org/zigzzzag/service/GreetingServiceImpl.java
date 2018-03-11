package org.zigzzzag.service;

import org.springframework.stereotype.Service;
import org.zigzzzag.model.Greeting;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final Map<Long, Greeting> allGreetings = new ConcurrentHashMap<>();

    @Override
    public Greeting create(long id, String content) {
        Greeting newGreeting = GreetingService.super.create(id, content);
        allGreetings.put(id, newGreeting);
        return newGreeting;
    }

    @Override
    public Greeting delete(long id) {
        return allGreetings.remove(id);
    }

    @Override
    public Collection<Greeting> allGreetings() {
        return allGreetings.values();
    }
}
