package br.com.microservice.statefulanyapi.infra;

import br.com.microservice.statefulanyapi.core.client.TokenClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;


@Configuration(proxyBeanMethods = false)
@ImportHttpServices(TokenClient.class)
public class HttpInterfaceConfig {
}
