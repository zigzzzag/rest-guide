package org.zigzzzag.functional_interface;

import org.zigzzzag.model.Greeting;

@FunctionalInterface
public interface GreetingCreator {

    Greeting create(long id, String content);
}
