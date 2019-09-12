package com.apl.brokr.dto.mappers;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.model.Role;
import com.apl.brokr.model.entities.Address;
import com.apl.brokr.model.entities.Broker;

public class BrokerMapper {

    public static Broker toEntity(RegistrationDataDto data){
        Broker broker = new Broker();


        broker.setId(data.getId());
        broker.setCompanyName(data.getCompanyName());
        broker.setFirstName(data.getFirstName());
        broker.setLastName(data.getLastName());
        broker.setKrsNumber(data.getKrsNumber());
        broker.setNipNumber(data.getNipNumber());
        broker.setRegonNumber(data.getRegonNumber());
        broker.setPkdNumber(data.getPkdNumber());

        Address address = new Address();
        address.setStreet(data.getStreet());
        address.setCity(data.getCity());
        address.setPostalCode(data.getPostalCode());
        address.setCommune(data.getCommune());
        address.setDistrict(data.getDistrict());
        address.setProvince(data.getProvince());
        address.setCountry(data.getCountry());

        broker.setAddress(address);

        broker.setUsername(data.getUsername());
        broker.setPassword(data.getPassword());
        broker.setEmail(data.getEmail());
        broker.setPhoneNumber(data.getPhoneNumber());
        broker.setRole(Role.BROKER);
        broker.setLicenceNumber(data.getLicenceNumber());
        return broker;

    }

    public static RegistrationDataDto toDto(Broker broker){
        RegistrationDataDto data = new RegistrationDataDto();

        data.setId(broker.getId());
        data.setCompanyName(broker.getCompanyName());
        data.setFirstName(broker.getFirstName());
        data.setLastName(broker.getLastName());
        data.setKrsNumber(broker.getKrsNumber());
        data.setNipNumber(broker.getNipNumber());
        data.setRegonNumber(broker.getRegonNumber());
        data.setPkdNumber(broker.getPkdNumber());

        Address address = broker.getAddress();
        data.setStreet(address.getStreet());
        data.setCity(address.getCity());
        data.setPostalCode(address.getPostalCode());
        data.setCommune(address.getCommune());
        data.setDistrict(address.getDistrict());
        data.setProvince(address.getProvince());
        data.setCountry(address.getCountry());

        data.setUsername(broker.getUsername());
        data.setPassword(broker.getPassword());
        data.setEmail(broker.getEmail());
        data.setPhoneNumber(broker.getPhoneNumber());
        data.setRole(broker.getRole().toString());
        data.setLicenceNumber(broker.getLicenceNumber());

        return data;
    }
}
