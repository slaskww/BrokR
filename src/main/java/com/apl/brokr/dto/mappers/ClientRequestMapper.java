package com.apl.brokr.dto.mappers;

import com.apl.brokr.dto.RequestDataDto;
import com.apl.brokr.model.entities.ClientRequest;




public class ClientRequestMapper {



    public static ClientRequest toEntity(RequestDataDto dataDto){

        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setSubcategories(dataDto.getSubcategories());
        clientRequest.setGeneralInsuranceCategory(dataDto.getSubcategories().get(0).getGeneralCat());
        clientRequest.setClient(dataDto.getClient());

        return clientRequest;
    }


    public static RequestDataDto toDto(ClientRequest clientRequest){

        RequestDataDto dataDto = new RequestDataDto();
        dataDto.setSubcategories(clientRequest.getSubcategories());
        dataDto.setGeneralInsuranceCategory(clientRequest.getGeneralInsuranceCategory());
        dataDto.setClient(clientRequest.getClient());

        return dataDto;
    }
}
