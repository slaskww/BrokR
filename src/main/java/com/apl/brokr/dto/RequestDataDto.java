package com.apl.brokr.dto;

import com.apl.brokr.model.entities.Client;
import com.apl.brokr.model.entities.GeneralInsuranceCategory;
import com.apl.brokr.model.entities.InsuranceSubcategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
public class RequestDataDto {

    private Client client;
    private List<InsuranceSubcategory> subcategories = new ArrayList<>();
    private GeneralInsuranceCategory generalInsuranceCategory;


}
