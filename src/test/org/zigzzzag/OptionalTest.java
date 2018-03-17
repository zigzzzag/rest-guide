package org.zigzzzag;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    @Test
    public void optionalEmptyTest() {
        Optional emptyOptional = Optional.empty();
        assertFalse(emptyOptional.isPresent());
    }

    @Test
    public void optionalOfTest() {
        Optional<String> op = Optional.of("zigzzzag");
        assertTrue(op.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void optionalOfTestNPE() {
        Optional.of(null);
    }

    @Test
    public void optionalOfNullableTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        assertTrue(op.isPresent());

        op = Optional.ofNullable(null);
        assertFalse(op.isPresent());
    }

    @Test
    public void optionalGetTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        assertEquals("zigzzzag", op.get());
    }

    @Test(expected = NoSuchElementException.class)
    public void optionalNullGetTest() {
        Optional<String> op = Optional.ofNullable(null);
        assertNull(op.get());
    }

    @Test
    public void optionalIfPresentTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        final String[] res = {null};
        op.ifPresent(x -> res[0] = x + x);
        assertEquals("zigzzzagzigzzzag", res[0]);
    }

    @Test(expected = NullPointerException.class)
    public void optionalNullIfPresentTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        op.ifPresent(null);
    }

    @Test
    public void optionaFilterTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        assertTrue(op.filter(x -> x.equals("zigzzzag")).isPresent());
        assertFalse(op.filter(x -> x.equals("abc")).isPresent());
    }

    @Test
    public void optionaMapTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        assertTrue(8 == op.map(String::length).get());
    }

    @Test
    public void optionaFlatMapTest() {
        Optional<String> op = Optional.ofNullable("zigzzzag");
        assertTrue(8 == op.flatMap(x -> Optional.of(x.length())).get());
    }
}
