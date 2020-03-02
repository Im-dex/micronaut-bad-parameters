package no.parameters;

import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.annotation.Get;

@Client("/")
public interface TestClient {
    @Get("/foo")
    String index(@QueryValue("param") String param);
}
