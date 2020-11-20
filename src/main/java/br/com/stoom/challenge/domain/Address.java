package br.com.stoom.challenge.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
    @GeneratedValue
    private Long id;

	private String streetName;
	private String number;
	private String complement;
	private String neighbourhood;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	private double latitude;
	private double longitude;
	
	public String getCompleteAddres(){
        StringBuilder address = new StringBuilder()
            .append(streetName).append(", ")
            .append(number).append(" - ")
            .append(neighbourhood).append(", ")
            .append(city).append(" - ")
            .append(state).append(", ")
            .append(zipcode).append(", ")
            .append(country);
        return address.toString();
    }
}
