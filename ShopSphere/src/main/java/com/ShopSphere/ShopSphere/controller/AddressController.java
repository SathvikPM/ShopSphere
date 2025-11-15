package com.ShopSphere.ShopSphere.controller;


import com.ShopSphere.ShopSphere.dto.AddressRequestDTO;
import com.ShopSphere.ShopSphere.dto.AddressResponseDTO;
import com.ShopSphere.ShopSphere.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    public  final AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressResponseDTO>  createAddress(@Valid @RequestBody AddressRequestDTO addressRequest){

        AddressResponseDTO addressResponse=addressService.createAddress(addressRequest);
        return ResponseEntity.ok(addressResponse);
    }

}
