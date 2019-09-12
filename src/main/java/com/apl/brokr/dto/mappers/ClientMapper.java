package com.apl.brokr.dto.mappers;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.model.Role;
import com.apl.brokr.model.entities.Address;
import com.apl.brokr.model.entities.Client;

public class ClientMapper {

    public static Client toEntity(RegistrationDataDto data){
        Client client = new Client();


        client.setId(data.getId());
        client.setCompanyName(data.getCompanyName());
        client.setFirstName(data.getFirstName());
        client.setLastName(data.getLastName());
        client.setKrsNumber(data.getKrsNumber());
        client.setNipNumber(data.getNipNumber());
        client.setRegonNumber(data.getRegonNumber());
        client.setPkdNumber(data.getPkdNumber());

        Address address = new Address();
        address.setStreet(data.getStreet());
        address.setCity(data.getCity());
        address.setPostalCode(data.getPostalCode());
        address.setCommune(data.getCommune());
        address.setDistrict(data.getDistrict());
        address.setProvince(data.getProvince());
        address.setCountry(data.getCountry());

        client.setAddress(address);

        client.setUsername(data.getUsername());
        client.setPassword(data.getPassword());
        client.setEmail(data.getEmail());
        client.setPhoneNumber(data.getPhoneNumber());
        client.setRole(Role.CLIENT);

        return client;

    }

    public static RegistrationDataDto toDto(Client client){
        RegistrationDataDto data = new RegistrationDataDto();

        data.setId(client.getId());
        data.setCompanyName(client.getCompanyName());
        data.setFirstName(client.getFirstName());
        data.setLastName(client.getLastName());
        data.setKrsNumber(client.getKrsNumber());
        data.setNipNumber(client.getNipNumber());
        data.setRegonNumber(client.getRegonNumber());
        data.setPkdNumber(client.getPkdNumber());

        Address address = client.getAddress();
        data.setStreet(address.getStreet());
        data.setCity(address.getCity());
        data.setPostalCode(address.getPostalCode());
        data.setCommune(address.getCommune());
        data.setDistrict(address.getDistrict());
        data.setProvince(address.getProvince());
        data.setCountry(address.getCountry());

        data.setUsername(client.getUsername());
        data.setPassword(client.getPassword());
        data.setEmail(client.getEmail());
        data.setPhoneNumber(client.getPhoneNumber());
        data.setRole(client.getRole().toString());

        return data;
    }
}
