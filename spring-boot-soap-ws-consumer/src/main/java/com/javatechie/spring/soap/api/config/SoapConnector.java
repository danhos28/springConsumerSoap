package com.javatechie.spring.soap.api.config;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapConnector extends WebServiceGatewaySupport {

    public Object callWebService(Object request, String soapAction) {
        return getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(soapAction));
    }
}

