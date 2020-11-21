package br.com.stoom.challenge.api;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<AddressResource> toResourceList(List<Address> addresses) {
    	List<AddressResource> addressResources = new ArrayList<>();
    	
    	for(Address address : addresses) {
    		addressResources.add(toResource(address));
    	}
    	
        return addressResources;
    }
    
    
    
    public void copyToDomainObject(AddressResource input, Address address) {
        modelMapper.map( input, address);
    }
}
