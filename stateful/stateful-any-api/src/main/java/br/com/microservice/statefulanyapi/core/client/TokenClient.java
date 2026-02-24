package br.com.microservice.statefulanyapi.core.client;

import br.com.microservice.statefulanyapi.core.dto.AuthUserResponse;
import br.com.microservice.statefulanyapi.core.dto.TokenDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "${app.client.base-url}")
public interface TokenClient {

    @PostExchange("api/auth/token/validate")
    TokenDTO validateToken(@RequestHeader String accessToken);

    @GetExchange("api/auth/user")
    AuthUserResponse getAuthenticatedUser(@RequestHeader String accessToken);
}