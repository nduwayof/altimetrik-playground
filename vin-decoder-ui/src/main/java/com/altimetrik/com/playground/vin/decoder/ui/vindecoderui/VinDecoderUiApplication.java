package com.altimetrik.com.playground.vin.decoder.ui.vindecoderui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VinDecoderUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinDecoderUiApplication.class, args);
	}

}
