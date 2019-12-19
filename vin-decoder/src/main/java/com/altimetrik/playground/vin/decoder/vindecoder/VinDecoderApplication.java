package com.altimetrik.playground.vin.decoder.vindecoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class VinDecoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinDecoderApplication.class, args);
    }

}
