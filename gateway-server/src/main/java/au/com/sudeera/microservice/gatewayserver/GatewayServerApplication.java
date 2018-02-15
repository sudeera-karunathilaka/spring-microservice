package au.com.sudeera.microservice.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import au.com.sudeera.microservice.gatewayserver.filter.ErrorFilter;
import au.com.sudeera.microservice.gatewayserver.filter.PostFilter;
import au.com.sudeera.microservice.gatewayserver.filter.PreFilter;
import au.com.sudeera.microservice.gatewayserver.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
	    return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	    return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	    return new RouteFilter();
	}
}
