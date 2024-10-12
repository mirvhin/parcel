package com.gcash.parcel;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ParcelApiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ParcelApiApplication.class);
        String port = System.getenv("PORT");
        if (port != null) {
            app.setDefaultProperties(Collections.singletonMap("server.port", port));
        }
        app.run(args);
    }

	@Bean
	public RestTemplate restTemplate() {
			return new RestTemplate();
	}
}
