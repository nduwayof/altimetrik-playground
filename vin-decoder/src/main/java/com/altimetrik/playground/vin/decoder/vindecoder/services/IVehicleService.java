package com.altimetrik.playground.vin.decoder.vindecoder.services;

import com.altimetrik.playground.vin.decoder.vindecoder.models.Make;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Model;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Vehicle;

import java.util.List;

/**
 * The interface Vehicle service.
 * @author fabrice
 * @version 1.0
 */
public interface IVehicleService {

    Vehicle getVehicleByVin(String vin);

    List<Make> getVehicleMakesByVehicleType(String vehicleType);

    List<Model> getVehicleModelsByVehicleMake(String make);
}
