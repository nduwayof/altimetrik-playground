package com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.dto;

import com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.models.Make;
import com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.models.Model;
import com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "vehicle", url = "http://localhost:8090/api/vehicle/")
public interface IVehicleFacade {

    @GetMapping(value = "/{vin}")
    Vehicle getVehicleDetails(@PathVariable(value = "vin") String vin);

    @GetMapping(value = "/type")
    List<Make> getVehicleMakesByVehicleType(@RequestParam("type") String type);

    @GetMapping(value = "/make")
    List<Model> getVehicleModelsByVehicleMake(@RequestParam("make") String make);

}
