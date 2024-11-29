package com.example.config;

import com.example.ws.CompteSoapService;
import jakarta.xml.ws.Endpoint;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {

    @Autowired
    private CompteSoapService compteSoapService; // Automatically injected by Spring
    private Bus bus; // Automatically injected by Spring

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, compteSoapService);
        endpoint.publish("/ws"); // Publish the SOAP service at the correct path
        return endpoint;
    }

}
