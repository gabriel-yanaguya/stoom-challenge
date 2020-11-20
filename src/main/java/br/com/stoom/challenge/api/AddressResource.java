package br.com.stoom.challenge.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = true)

class AddressResource extends RepresentationModel {
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
 }