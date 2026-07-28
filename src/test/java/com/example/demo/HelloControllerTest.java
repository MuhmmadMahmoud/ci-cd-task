package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    HelloController controller = new HelloController();

    @Test
    public void testHomePage() {
        assertEquals("Hello from my CI CD task app", controller.home());
    }

    @Test
    public void testSayHello() {
        assertEquals("Hello Muhmmad !", controller.sayHello("Muhmmad"));
    }

    @Test
    public void testAddEndpoint() {
        assertEquals("the result is 8", controller.add(5, 3));
    }

}
