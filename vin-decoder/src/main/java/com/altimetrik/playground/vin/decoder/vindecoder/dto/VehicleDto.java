package com.altimetrik.playground.vin.decoder.vindecoder.dto;

import com.altimetrik.playground.vin.decoder.vindecoder.models.Make;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Model;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Vehicle;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Vehicle dto.
 * @author fabrice
 * @version 1.0
 */
@Component
public class VehicleDto implements IVehicleDto{

    @Value("${vin.decoder.base.url}")
    private String baseUrl;


    @Override
    public String decodedData(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(baseUrl + url, String.class);
    }

    @Override
    public Vehicle constructVehicleObject(String decodedData) {
        JSONObject decodedJSON = new JSONObject(decodedData);
        decodedJSON = decodedJSON.getJSONArray("Results").getJSONObject(0);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleVIN(decodedJSON.getString("VIN"));
        vehicle.setVehicleMake(decodedJSON.getString("Make"));
        vehicle.setVehicleModel(decodedJSON.getString("Model"));
        vehicle.setVehicleYear(decodedJSON.getString("ModelYear"));
        vehicle.setVehiclePlantCountry(decodedJSON.getString("PlantCountry"));
        vehicle.setVehiclePlantState(decodedJSON.getString("PlantState"));
        vehicle.setVehicleType(decodedJSON.getString("VehicleType"));
        vehicle.setVehiclePlantCity(decodedJSON.getString("PlantCity"));
        return vehicle;
    }

    @Override
    public List<Make> constructMakeObject(String decodedData) {
        JSONObject decodedJSON = new JSONObject(decodedData);
        JSONArray makesArray =  decodedJSON.getJSONArray("Results");
        List<Make> makes = new ArrayList<>();
        for(int i = 0; i< makesArray.length(); i++){
            JSONObject jsonObject = makesArray.getJSONObject(i);
            Make make = new Make();
            make.setMakeId(jsonObject.getInt("MakeId"));
            make.setMakeName(jsonObject.getString("MakeName"));
            make.setVehicleTypeId(jsonObject.getInt("VehicleTypeId"));
            make.setVehicleTypeName(jsonObject.getString("VehicleTypeName"));
            makes.add(make);
        }
        return makes;
    }

    @Override
    public List<Model> constructModelObject(String decodedData) {
        JSONObject decodedJSON = new JSONObject(decodedData);
        JSONArray makesArray =  decodedJSON.getJSONArray("Results");
        List<Model> models = new ArrayList<>();
        for(int i = 0; i< makesArray.length(); i++){
            JSONObject jsonObject = makesArray.getJSONObject(i);
            Model model = new Model();
            model.setMake_ID(jsonObject.getInt("Make_ID"));
            model.setMake_Name(jsonObject.getString("Make_Name"));
            model.setModel_ID(jsonObject.getInt("Model_ID"));
            model.setModel_Name(jsonObject.getString("Model_Name"));
            models.add(model);
        }
        return models;
    }
}
