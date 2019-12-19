package com.altimetrik.playground.vin.decoder.vindecoder.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Make {

    private int MakeId;
    private String MakeName;
    private int VehicleTypeId;
    private String VehicleTypeName;

}
