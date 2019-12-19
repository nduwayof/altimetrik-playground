package com.altimetrik.playground.vin.decoder.vindecoder.services;

import com.altimetrik.playground.vin.decoder.vindecoder.dto.IVehicleDto;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Make;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Model;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService{

    private IVehicleDto vehicleDto;

    @Autowired
    public VehicleService(IVehicleDto vehicleDto){
        this.vehicleDto = vehicleDto;
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        String decodedData = this.vehicleDto.decodedData("/decodevinvalues/" + vin + "?format=json");
        return this.vehicleDto.constructVehicleObject(decodedData);
    }

    @Override
    public List<Make> getVehicleMakesByVehicleType(String vehicleType) {
        String decodeDta = this.vehicleDto.decodedData("/GetMakesForVehicleType/"+vehicleType+"?format=json");
        return this.vehicleDto.constructMakeObject(decodeDta);
    }

    @Override
    public List<Model> getVehicleModelsByVehicleMake(String make) {
        String decodeDta = this.vehicleDto.decodedData("/GetModelsForMake/"+make+"?format=json");
        return this.vehicleDto.constructModelObject(decodeDta);
    }
}
