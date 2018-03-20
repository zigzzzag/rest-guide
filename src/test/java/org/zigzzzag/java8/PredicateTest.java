package org.zigzzzag.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PredicateTest {

    @Test
    public void simpleTest() {
        List<String> l = new ArrayList<>();
        l.add("abc");
        l.add("abcd");
        l.add("abcde");
        l.add("abcdefg");

        l.removeIf(x -> x.length() < 5);
        Assert.assertEquals("abcde", l.get(0));
        Assert.assertEquals("abcdefg", l.get(1));
    }
}
