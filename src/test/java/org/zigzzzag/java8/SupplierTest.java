package org.zigzzzag.java8;

import org.junit.Assert;
import org.junit.Test;
import org.zigzzzag.model.Greeting;

import java.util.function.Supplier;

public class SupplierTest {

    @Test
    public void simpleTest() {
        Supplier<String> s = () -> "Hello World";
        Assert.assertEquals("Hello World", s.get());
    }

    @Test
    public void greetingFactoryTest() {
        Supplier<Greeting> s = Greeting::new;
        Assert.assertNull(s.get().getContent());
    }
}
