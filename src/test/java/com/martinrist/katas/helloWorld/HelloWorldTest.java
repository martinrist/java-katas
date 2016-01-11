package com.martinrist.katas.helloWorld;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for sample "Hello World" kata from exercism.io.
 *
 * @see <a href="http://exercism.io/exercises/java/hello-world/readme"/>
 */
public class HelloWorldTest {

    @Test
    public void helloNoName() {
        assertEquals("Hello, World!", HelloWorld.hello(""));
        assertEquals("Hello, World!", HelloWorld.hello(null));
    }

    @Test
    public void helloSampleName() {
        assertEquals("Hello, Alice!", HelloWorld.hello("Alice"));
    }

    @Test
    public void helloAnotherSampleName() {
        assertEquals("Hello, Bob!", HelloWorld.hello("Bob"));
    }
}