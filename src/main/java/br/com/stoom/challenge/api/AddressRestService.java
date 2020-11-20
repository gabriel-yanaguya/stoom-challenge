package br.com.stoom.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stoom.challenge.domain.Address;
import br.com.stoom.challenge.service.AddressService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("v1/address")
public class AddressRestService {
 
    private AddressResourceAssembler addressResourceAssembler;
    private AddressService addressService;

    @Autowired
    public AddressRestService(AddressResourceAssembler addressResourceAssembler, AddressService addressService) {
        this.addressResourceAssembler = addressResourceAssembler;
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AddressResource input ){
        Address address = addressResourceAssembler.toModel(input);
        addressService.save(address);
        AddressResource addressResource = addressResourceAssembler.toResource(address);
        return ResponseEntity.ok(addressResource);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@RequestBody AddressResource input, @PathVariable Long id ){
        Address address = addressService.getById(id);
        addressResourceAssembler.copyToDomainObject(input, address);
        addressService.save(address);
        AddressResource addressResource = addressResourceAssembler.toResource(address);
        return ResponseEntity.ok(addressResource);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        Address address = addressService.getById(id);
        return ResponseEntity.ok(addressResourceAssembler.toResource(address));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Address address = addressService.getById(id);
        addressService.delete(address);
        return ResponseEntity.ok().build();
    }
 
}