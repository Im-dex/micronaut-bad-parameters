package no.parameters;

import io.micronaut.test.annotation.MicronautTest;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(transactional = false)
public class ParametersTest {
    @Inject
    TestClient client;

    @Test
    public void test() {
        String response = client.index("value");
        assertEquals(response, "value");
    }
}
