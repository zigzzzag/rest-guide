package org.zigzzzag.service;

import org.springframework.stereotype.Service;
import org.zigzzzag.model.Greeting;

import java.util.Collection;

@Service
public interface GreetingService {

    default Greeting create(long id, String content) {
        return new Greeting(id, content);
    }

    Greeting delete(long id);

    Collection<Greeting> allGreetings();
}
