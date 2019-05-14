package br.com.zup.jaeger.demo.configuration;

import feign.Client;
import feign.Feign;
import feign.okhttp.OkHttpClient;
import feign.opentracing.TracingClient;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Client client(){
        return new OkHttpClient();
    }

    @Bean
    public Feign feignBuilder(Client client, Tracer tracer){
        return Feign.builder()
                .client(new TracingClient(client, tracer))
                .build();
    }

}
