package com.ShopSphere.ShopSphere.service;

import com.ShopSphere.ShopSphere.dto.AddressRequestDTO;
import com.ShopSphere.ShopSphere.dto.AddressResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    AddressResponseDTO createAddress(AddressRequestDTO addressRequest);

    List<AddressResponseDTO> getAllAddress();

    AddressResponseDTO getAddressById(Long id);

    AddressResponseDTO updateAddress(Long id,AddressRequestDTO addressRequest);

    void deleteAddress();


}
