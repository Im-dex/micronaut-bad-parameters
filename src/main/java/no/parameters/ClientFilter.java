package no.parameters;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

@Filter("/**")
public class ClientFilter implements HttpClientFilter {
    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
        String param = request.getParameters().get("param", String.class).orElse("");
        if (param.isEmpty()) {
            return Flowable.error(new RuntimeException("Parameter not found"));
        } else {
            return chain.proceed(request);
        }
    }
}
