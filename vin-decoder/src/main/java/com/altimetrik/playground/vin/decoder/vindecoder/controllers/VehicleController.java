package com.altimetrik.playground.vin.decoder.vindecoder.controllers;

import com.altimetrik.playground.vin.decoder.vindecoder.models.Make;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Model;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Vehicle;
import com.altimetrik.playground.vin.decoder.vindecoder.services.IVehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehicle/")
public class VehicleController {

    private IVehicleService vehicleService;

    @Autowired
    public VehicleController(IVehicleService  vehicleService){
        this.vehicleService = vehicleService;
    }


    @GetMapping(value = "/{vin}")
    @ApiOperation(value = "Find vehicle details by vin number", response = Vehicle.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully retrieved the vehicle details"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle getVehicleDetails(@PathVariable(value = "vin") String vin){
        return this.vehicleService.getVehicleByVin(vin);
    }

    @GetMapping(value = "/type")
    @ApiOperation(value = "Finding all makes by vehicle type", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns the vehicle details"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Make> getVehicleMakesByVehicleType(@RequestParam("type") String type){
        return this.vehicleService.getVehicleMakesByVehicleType(type);
    }


    @GetMapping(value = "/make")
    @ApiOperation(value = "Finding all models by vehicle make", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns vehicle all the makes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Model> getVehicleModelsByVehicleMake(@RequestParam("make") String make){
        return this.vehicleService.getVehicleModelsByVehicleMake(make);
    }

}
