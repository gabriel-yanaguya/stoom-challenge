package br.com.stoom.challenge.service;

import br.com.stoom.challenge.domain.Address;

public interface AddressService {
	
	Address getById(Long id);
	Address save(Address address);
	Address update(Address address);
	void delete(Address address);
}
