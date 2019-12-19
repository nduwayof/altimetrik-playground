package com.altimetrik.playground.vin.decoder.vindecoder;

import com.altimetrik.playground.vin.decoder.vindecoder.controllers.VehicleController;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Make;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Model;
import com.altimetrik.playground.vin.decoder.vindecoder.models.Vehicle;
import com.altimetrik.playground.vin.decoder.vindecoder.services.IVehicleService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = VehicleController.class)
class VinDecoderApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IVehicleService vehicleService;

    @Test
    public void getDetailsForVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        Mockito.when(vehicleService.getVehicleByVin(Mockito.anyString())).thenReturn(vehicle);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/WAUFFAFM3CA000000")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(response.getStatus(), 201);
    }

    @Test
    public void getAllMakesByVehicleType() throws Exception {
        List<Make> makes = new ArrayList<>();
        Mockito.when(vehicleService.getVehicleMakesByVehicleType(Mockito.anyString())).thenReturn(makes);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/type?type=PASSENGER")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(response.getStatus(), 201);
    }

    @Test
    public void getAllModelsByVehicleMake() throws Exception {
        List<Model> models = new ArrayList<>();
        Mockito.when(vehicleService.getVehicleModelsByVehicleMake(Mockito.anyString())).thenReturn(models);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/make?make=AUDI")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        Assert.assertEquals(response.getStatus(), 201);
    }

}
