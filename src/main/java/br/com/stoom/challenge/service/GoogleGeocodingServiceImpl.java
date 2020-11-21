package br.com.stoom.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import br.com.stoom.challenge.domain.Address;

@Service
@Primary
public class GoogleGeocodingServiceImpl implements GoogleGeocodingService{

    private GeoApiContext googleGeoApi;

    @Autowired
    public GoogleGeocodingServiceImpl(GeoApiContext googleGeo) {
        this.googleGeoApi = googleGeo;
    }

    @Override
    public void fillGeolocalization(Address address) {
       if(address.getLatitude() != 0 && address.getLongitude() != 0)
           return;
        try {
            GeocodingResult[] results = GeocodingApi.geocode(googleGeoApi, address.getCompleteAddres()).await();
            if(results.length == 0) {
            	System.out.println("GEOLOCATION NOT FOUND");
            	return;
            }
            
            System.out.println("GEOLOCATION FOUND: "+results[0].geometry.location.lat);
            LatLng latLng = results[0].geometry.location;
            address.setLatitude(latLng.lat);
            address.setLongitude(latLng.lng);
            
        } catch (Exception e) {
        	System.out.println("GEOLOCATION ERROR: " + e.getMessage());
            throw new RuntimeException("ERROR searching for data at Google Geo Api");
        }
    }
}