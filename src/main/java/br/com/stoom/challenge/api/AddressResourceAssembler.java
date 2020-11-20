package br.com.stoom.challenge.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.stoom.challenge.domain.Address;

@Component
public class AddressResourceAssembler {

	private ModelMapper modelMapper;
    
    @Autowired
    public AddressResourceAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Address toModel(AddressResource input) {
        return modelMapper.map(input, Address.class);
    }

    public AddressResource toResource(Address address) {
        return modelMapper.map( address, AddressResource.class );
    }
    
    public void copyToDomainObject(AddressResource input, Address address) {
        modelMapper.map( input, address);
    }
}
