package com.javatechie.spring.soap.api;

import com.javatechie.spring.soap.api.config.SoapConnector;
import com.javatechie.spring.soap.api.wsdl.Add;
import com.javatechie.spring.soap.api.wsdl.AddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootSopaWsClientApplication {

	@Autowired
	private SoapConnector soapConnector;
	
	@PostMapping("/add")
	public AddResponse invokeSoapClient(@RequestBody Add request) {
		AddResponse addRes = (AddResponse) soapConnector.callWebService(request, "http://tempuri.org/Add");
		return addRes;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSopaWsClientApplication.class, args);
	}

}
