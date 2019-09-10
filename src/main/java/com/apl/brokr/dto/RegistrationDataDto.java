package com.apl.brokr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class RegistrationDataDto {

    private Long id;
    @NotBlank(message = "Pole nie może być puste")
    private String companyName;
    private String firstName;
    private String lastName;
    @NotBlank(message = "Pole nie może być puste")
    private String krsNumber;
    @NotBlank(message = "Pole nie może być puste")
    private String nipNumber;
    @NotBlank(message = "Pole nie może być puste")
    private String regonNumber;
    @NotBlank(message = "Pole nie może być puste")
    private String pkdNumber;

    @NotBlank(message = "Pole nie może być puste")
    private String street;
    @NotBlank(message = "Pole nie może być puste")
    private String postalCode;
    @NotBlank(message = "Pole nie może być puste")
    private String city;
    private String district; //powiat
    private String commune; // gmina
    private String province;  //wojew.
    private String country;

    @NotBlank(message = "Pole nie może być puste")
    @Size(min = 7, max = 20, message = "Nazwa użytkownika powinna zawierać od 7 do 20 znaków")
    private String username;
    @NotBlank(message = "Pole nie może być puste")
    @Size(min = 8, max = 12, message = "Hasło powinno zawierać od 8 do 15 znaków")
    private String password;
    @NotBlank(message = "Pole nie może być puste")
    @Size(min = 8, max = 12, message = "Hasło powinno zawierać od 8 do 15 znaków")
    private String confirmedPassword;
    @NotBlank(message = "Pole nie może być puste")
    @Email(message = "Błędny format adresu email")
    private String email;
    @NotBlank(message = "Pole nie może być puste")
    private String phoneNumber;
    private String role;
    private String licenceNumber;
}
