package com.altimetrik.playground.vin.decoder.vindecoder.dto;

import com.altimetrik.playground.vin.decoder.vindecoder.models.Make;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Model;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Vehicle;
import org.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * The interface Vehicle dto.
 * @author fabrice
 * @version 1.0
 */
@FeignClient(name = "vehicle", url = "https://vpic.nhtsa.dot.gov/api/")
public interface IVehicleDto {
    /**
     * Decoded data string.
     *
     * @param url the url
     * @return the string
     */
    String decodedData(String url);


    Vehicle constructVehicleObject(String decodedData);

    List<Make> constructMakeObject(String decodedData);

    List<Model> constructModelObject(String decodedData);
}
