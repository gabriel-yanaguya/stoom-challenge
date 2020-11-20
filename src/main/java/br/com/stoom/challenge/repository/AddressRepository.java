package br.com.stoom.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.stoom.challenge.domain.Address;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {}
