package com.example.crudapp.Controller;


import com.example.crudapp.Exception.ResourceNotFoundException;
import com.example.crudapp.Model.Address;
import com.example.crudapp.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class AddressController {
    @Autowired
    AddressRepository repository;

    // get All Addresses
    @GetMapping("/address")
    public List<Address> getAllAddresses(){
        return this.repository.findAll();

    }
//    @GetMapping("/address/{id}")
//    public ResponseEntity<Address> getAddressByZip(@PathVariable(value = "id")Integer zip) throws ResourceNotFoundException {
//
//            Address address=repository.findById(zip).
//                    orElseThrow();
//            new ResourceNotFoundException("Address not fount for this zip");
//            return ResponseEntity.ok().body(address);
//
//    }
    @GetMapping("/address/{state}")

    public List<Address> findByCityName(@PathVariable String state){
        List<Address> customers = repository.getUserByCity(state);
        List<Address> customerUI = new ArrayList<>();
        for (Address customer : customers) {
            customerUI.add(new Address(customer.getZip(),customer.getCity(),customer.getDst(),customer.getLatitude(),customer.getLongitude(), customer.getTimezone()));
        }
        return customerUI;
    }
    // To Save Address
    @PostMapping("/create")
    public Address craeteAddress(@RequestBody Address address){
        return this.repository.save(address);
    }

    // To Update
    @PutMapping("address/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value ="id")Integer zip ,@RequestBody Address details) throws ResourceNotFoundException{
        Address address=repository.findById(zip).
                orElseThrow();
        new ResourceNotFoundException("Address not fount for this zip");
        address.setState(details.getState());
        address.setCity(details.getCity());
        return ResponseEntity.ok(this.repository.save(address));
    }

    // To Delete
    @DeleteMapping("/address/{id}")
    public Map<String,Boolean> deleteAddress(@PathVariable(value = "id")Integer zip) throws ResourceNotFoundException{
        Address address=repository.findById(zip).
                orElseThrow();
        new ResourceNotFoundException("Unable to Delete");
        this.repository.delete(address);
        Map<String, Boolean> response=new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }
}
