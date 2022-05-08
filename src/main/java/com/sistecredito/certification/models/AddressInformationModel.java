package com.sistecredito.certification.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressInformationModel {

    private String emailAddress;
    private String state;
    private String city;
    private String address;
    private String aditionalAddress;

}
