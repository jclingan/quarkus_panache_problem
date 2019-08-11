package org.acme.spring.web;

import io.quarkus.test.junit.SubstrateTest;

@SubstrateTest
public class NativeGreetingControllerIT extends GreetingControllerTest {

    // Execute the same tests but in native mode.
}