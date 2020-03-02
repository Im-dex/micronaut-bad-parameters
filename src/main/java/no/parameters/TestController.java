package no.parameters;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

@Controller
public class TestController {
    @Get("/foo")
    public String index(@QueryValue("param") String param) {
        return param;
    }
}
