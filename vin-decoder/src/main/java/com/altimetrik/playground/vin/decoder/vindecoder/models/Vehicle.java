package com.altimetrik.playground.vin.decoder.vindecoder.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private String vehicleVIN;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleYear;
    private String vehiclePlantCountry;
    private String vehiclePlantState;
    private String vehicleType;
    private String vehiclePlantCity;

}
