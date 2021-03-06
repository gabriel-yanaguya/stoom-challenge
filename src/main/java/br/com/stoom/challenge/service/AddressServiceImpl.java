package br.com.stoom.challenge.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stoom.challenge.domain.Address;
import br.com.stoom.challenge.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	private AddressRepository addressRepository;
	private GoogleGeocodingService googleGeocodingService;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, GoogleGeocodingService googleGeocodingService) {
        this.addressRepository = addressRepository;
        this.googleGeocodingService = googleGeocodingService;
    }
	 
	 @Override
	 public Address getById(Long id) {
		 Optional<Address> address = addressRepository.findById(id);
		 
		 if(address == null || !address.isPresent()) {
			 throw new RuntimeException("Address not found");
		 }
		 return address.get();
	 }
	 
	 @Override
	 public List<Address> getAll() {
		 Iterable<Address> addresses = addressRepository.findAll();
		 
		 
		 List<Address> adressesList = StreamSupport.stream(addresses.spliterator(), false)
				    .collect(Collectors.toList());
		 return adressesList;
	 }
	 
	 @Override
	 public Address save(Address address) {
		 googleGeocodingService.fillGeolocalization(address);
		 return addressRepository.save(address);
	 }

	@Override
	public Address update(Address address) {
		googleGeocodingService.fillGeolocalization(address);
		return addressRepository.save(address);
	}

	@Override
	public void delete(Address address) {
		addressRepository.delete(address);	
	}
}
