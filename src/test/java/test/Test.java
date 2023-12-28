package test;

import org.junit.jupiter.api.Assertions;

public class Test {
    @org.junit.jupiter.api.Test
    public void testConcat_validArgument_success() {
        // given:
        final String original = "Test string";
        final String argument = "valid";
        final String expected = "Test string valid";
        // when:
        final String result = original.concat(argument);

        // then:
        Assertions.assertEquals(expected,result);
    }
}
