package com.apl.brokr.dto.mappers;

import com.apl.brokr.dto.RegistrationDataDto;
import com.apl.brokr.model.Role;
import com.apl.brokr.model.entities.Address;
import com.apl.brokr.model.entities.User;

public class UserMapper {

    public static User toEntity(RegistrationDataDto data) {
        User user = new User();


        user.setId(data.getId());
        user.setCompanyName(data.getCompanyName());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setKrsNumber(data.getKrsNumber());
        user.setNipNumber(data.getNipNumber());
        user.setRegonNumber(data.getRegonNumber());
        user.setPkdNumber(data.getPkdNumber());

        Address address = new Address();
        address.setStreet(data.getStreet());
        address.setCity(data.getCity());
        address.setPostalCode(data.getPostalCode());
        address.setCommune(data.getCommune());
        address.setDistrict(data.getDistrict());
        address.setProvince(data.getProvince());
        address.setCountry(data.getCountry());

        user.setAddress(address);

        user.setUsername(data.getUsername());
        user.setPassword(data.getPassword());
        user.setEmail(data.getEmail());
        user.setPhoneNumber(data.getPhoneNumber());
        user.setRole(Role.CLIENT);

        return user;

    }

    public static RegistrationDataDto toDto(User user) {
        RegistrationDataDto data = new RegistrationDataDto();

        data.setId(user.getId());
        data.setCompanyName(user.getCompanyName());
        data.setFirstName(user.getFirstName());
        data.setLastName(user.getLastName());
        data.setKrsNumber(user.getKrsNumber());
        data.setNipNumber(user.getNipNumber());
        data.setRegonNumber(user.getRegonNumber());
        data.setPkdNumber(user.getPkdNumber());

        Address address = user.getAddress();
        data.setStreet(address.getStreet());
        data.setCity(address.getCity());
        data.setPostalCode(address.getPostalCode());
        data.setCommune(address.getCommune());
        data.setDistrict(address.getDistrict());
        data.setProvince(address.getProvince());
        data.setCountry(address.getCountry());

        data.setUsername(user.getUsername());
        data.setPassword(user.getPassword());
        data.setConfirmedPassword(user.getPassword());
        data.setEmail(user.getEmail());
        data.setPhoneNumber(user.getPhoneNumber());
      //  data.setRole(user.getRole().toString());

        System.out.println(data.toString());
        return data;
    }
}
