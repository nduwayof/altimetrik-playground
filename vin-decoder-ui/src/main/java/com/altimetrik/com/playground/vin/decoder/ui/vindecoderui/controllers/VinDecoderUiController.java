package com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.controllers;

import com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.dto.IVehicleFacade;
import com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.models.Make;
import com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The type Vin decoder ui controller.
 */
@Controller
@CrossOrigin(origins = {"http://localhost:8090"}, maxAge = 6000)
public class VinDecoderUiController {

    private IVehicleFacade vehicleFacade;

    @Value("${google.api.key}")
    public String apiKey;

    /**
     * Instantiates a new Vin decoder ui controller.
     *
     * @param vehicleFacade the vehicle facade
     */
    @Autowired
    public VinDecoderUiController(IVehicleFacade vehicleFacade){
        this.vehicleFacade = vehicleFacade;
    }

    /**
     * Index string.
     *
     * @param vin the vin
     * @return the string
     */
    @GetMapping(value = "/")
    public String index(@RequestParam(value = "vin", required = false) String vin, Model model){
        if(vin != null) {
            Vehicle vehicle = this.vehicleFacade.getVehicleDetails(vin);
            List<Make> makes = this.vehicleFacade.getVehicleMakesByVehicleType(vehicle.getVehicleType());
            List<com.altimetrik.com.playground.vin.decoder.ui.vindecoderui.models.Model> models = this
                    .vehicleFacade.getVehicleModelsByVehicleMake(vehicle.getVehicleMake());
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("makes", makes);
            model.addAttribute("models", models);
            model.addAttribute("api-key", apiKey);
        }
        return "index";
    }

}
