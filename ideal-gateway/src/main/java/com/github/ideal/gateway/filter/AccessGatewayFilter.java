package com.github.ideal.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author junliang
 * @date 2018/07/02
 */
@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain chain) {
        try {

            LinkedHashSet requiredAttribute = serverWebExchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
            ServerHttpRequest request = serverWebExchange.getRequest();
            String requestUri = request.getPath().pathWithinApplication().value();
            final String method = Objects.requireNonNull(request.getMethod()).toString();
            ServerHttpRequest.Builder mutate = request.mutate();
            ServerHttpRequest build = mutate.build();
            return chain.filter(serverWebExchange.mutate().request(build).build());
        } catch (Exception e){

            return getVoidMono(serverWebExchange,e.getLocalizedMessage());
        }
    }

    /**
     * 网关抛异常
     *
     * @param body
     */
    @NotNull
    private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, Object body) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }
}
