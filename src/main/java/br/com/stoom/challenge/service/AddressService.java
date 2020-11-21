package br.com.stoom.challenge.service;

import java.util.List;

import br.com.stoom.challenge.domain.Address;

public interface AddressService {
	
	Address getById(Long id);
	List<Address> getAll();
	Address save(Address address);
	Address update(Address address);
	void delete(Address address);
}
