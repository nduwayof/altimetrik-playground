package com.altimetrik.playground.vin.decoder.vindecoder.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private int Make_ID;
    private String Make_Name;
    private int Model_ID;
    private String Model_Name;

}
