package org.zigzzzag;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
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

    @SuppressWarnings("unusedLocal")
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
}
