package com.ShopSphere.ShopSphere.serviceimpl;

import com.ShopSphere.ShopSphere.dto.AddressRequestDTO;
import com.ShopSphere.ShopSphere.dto.AddressResponseDTO;
import com.ShopSphere.ShopSphere.model.Address;
import com.ShopSphere.ShopSphere.repository.AddressRepository;
import com.ShopSphere.ShopSphere.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper){

        this.addressRepository=addressRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public AddressResponseDTO createAddress(AddressRequestDTO addressRequest) {
//        Address address=new Address();
//        address.setStreet(addressRequest.getStreet());
//        address.setCity(addressRequest.getCity());
//        address.setState(addressRequest.getState());
//        address.setCountry(addressRequest.getCountry());
//        address.setPincode(addressRequest.getPincode());
//        address.setType(addressRequest.getType());
//        Address saved=addressRepository.save(address);
//
//        AddressResponseDTO addressResponse=new AddressResponseDTO();
//        addressResponse.setId(saved.getId());
//        addressResponse.setStreet(saved.getStreet());
//        addressResponse.setCity(saved.getCity());
//        addressResponse.setState(saved.getState());
//        addressResponse.setCountry(saved.getCountry());
//        addressResponse.setPincode(saved.getPincode());
//        addressResponse.setType(saved.getType());


        Address address=modelMapper.map(addressRequest,Address.class);
        Address saved=addressRepository.save(address);
        AddressResponseDTO addressResponse=modelMapper.map(saved,AddressResponseDTO.class);

        return addressResponse;


    }


    @Override
    public List<AddressResponseDTO> getAllAddress() {
        return null;
    }

    @Override
    public AddressResponseDTO getAddressById(Long id) {
        return null;
    }

    @Override
    public AddressResponseDTO updateAddress(Long id, AddressRequestDTO addressRequest) {
        return null;
    }

    @Override
    public void deleteAddress() {

    }
}
