package br.com.stoom.challenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.maps.GeoApiContext;

@Configuration
public class GoogleGeocodingConfig {
	
	@Value( "${google.geocoding-api-key}" )
	private String apiKey;

	@Bean
	public GeoApiContext geoApiContext() {
	    GeoApiContext context = new GeoApiContext.Builder()
	        .apiKey(apiKey)
	        .build();
	    return context;
	}
}
