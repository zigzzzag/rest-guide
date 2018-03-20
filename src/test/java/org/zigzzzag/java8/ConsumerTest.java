package org.zigzzzag.java8;

import org.junit.Assert;
import org.junit.Test;
import org.zigzzzag.model.Greeting;

import java.util.function.Consumer;

public class ConsumerTest {

    @Test
    public void simpleTest() {
        Consumer<Greeting> c = x -> Assert.assertEquals(42, x.getId());
        c.accept(new Greeting(42, ""));
    }
}
