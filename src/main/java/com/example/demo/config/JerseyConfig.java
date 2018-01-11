package com.example.demo.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
@ApplicationPath("/api")
@Api(value = "Hello resource", produces = "application/json")
public class JerseyConfig extends ResourceConfig{

	 @Value("${spring.jersey.application-path:/}")
	 private String apiPath;
	
	public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.example.demo.rest");
    }
	
	
	
	@PostConstruct
	public void init() {
	// Register components where DI is needed
	    this.configureSwagger();
	}
	
	 private void configureSwagger() {
		      // Available at localhost:port/api/swagger.json
		      this.register(ApiListingResource.class);
		      this.register(SwaggerSerializers.class);
		  
		      BeanConfig config = new BeanConfig();
		      config.setConfigId("springboot-jersey-swagger-demo-example");
		      config.setTitle("Spring Boot + Jersey + Swagger + E Nóis");
		      config.setVersion("v1");
		      config.setContact("Dieggo Carrilho");
		      config.setSchemes(new String[] { "http", "https" });
		      config.setBasePath(this.apiPath);
		      config.setResourcePackage("com.example.demo.rest");
		      config.setPrettyPrint(true);
		      config.setScan(true);
		}
}
