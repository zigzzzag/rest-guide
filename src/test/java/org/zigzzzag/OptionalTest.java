package org.zigzzzag;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"SpellCheckingInspection", "ConstantConditions"})
public class OptionalTest {

    private static final String TEST_STR = "zigzzzag";

    @Test
    public void optionalEmptyTest() {
        Optional emptyOptional = Optional.empty();
        assertFalse(emptyOptional.isPresent());
    }

    @Test
    public void optionalOfTest() {
        Optional<String> op = Optional.of(TEST_STR);
        assertTrue(op.isPresent());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expected = NullPointerException.class)
    public void optionalOfTestNPE() {
        Optional.of(null);
    }

    @Test
    public void optionalOfNullableTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        assertTrue(op.isPresent());

        op = Optional.ofNullable(null);
        assertFalse(op.isPresent());
    }

    @Test
    public void optionalGetTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        assertEquals(TEST_STR, op.get());
    }

    @Test(expected = NoSuchElementException.class)
    public void optionalNullGetTest() {
        Optional<String> op = Optional.ofNullable(null);
        assertNull(op.get());
    }

    @Test
    public void optionalIfPresentTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        final String[] res = {null};
        op.ifPresent(x -> res[0] = x + x);
        assertEquals("zigzzzagzigzzzag", res[0]);
    }

    @Test(expected = NullPointerException.class)
    public void optionalNullIfPresentTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        op.ifPresent(null);
    }

    @Test
    public void optionaFilterTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        assertTrue(op.filter(x -> x.equals(TEST_STR)).isPresent());
        assertFalse(op.filter(x -> x.equals("abc")).isPresent());
    }

    @Test
    public void optionaMapTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        assertEquals(8, (int) op.map(String::length).get());
    }

    @Test
    public void optionaFlatMapTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        assertEquals(8, (int) op.flatMap(x -> Optional.of(x.length())).get());
    }

    @Test
    public void optionaOrElseTest() {
        Optional<String> op = Optional.ofNullable(TEST_STR);
        assertEquals(TEST_STR, op.orElse("hell"));

        op = Optional.ofNullable(null);
        assertEquals("hell", op.orElse("hell"));

        {
            Optional<String> op1 = Optional.ofNullable(TEST_STR);
            assertEquals(TEST_STR, op1.orElseGet(() -> op1.get() + " hell"));
        }

        {
            Optional<String> op2 = Optional.ofNullable(null);
            assertEquals("welcome to hell", op2.orElseGet(() -> op2.orElse("welcome to") + " hell"));
        }

        op = Optional.ofNullable(TEST_STR);
        assertEquals(TEST_STR, op.orElseThrow(IllegalStateException::new));
    }

    @Test(expected = IllegalStateException.class)
    public void optionaOrElseThrowTest() {
        Optional<String> op = Optional.ofNullable(null);
        assertEquals(TEST_STR, op.orElseThrow(IllegalStateException::new));
    }
}
