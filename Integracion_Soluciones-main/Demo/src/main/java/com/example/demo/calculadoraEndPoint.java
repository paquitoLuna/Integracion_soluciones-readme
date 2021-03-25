package com.example.demo;

import org.example.calculadora.MultiplicarRequest;
import org.example.calculadora.MultiplicarResponse;
import org.example.calculadora.DividirResponse;
import org.example.calculadora.DividirRequest;
import org.example.calculadora.RestarRequest;
import org.example.calculadora.RestarResponse;
import org.example.calculadora.SumarRequest;
import org.example.calculadora.SumarResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class calculadoraEndPoint {

    @PayloadRoot(namespace = "http://www.example.org/calculadora", localPart = "sumarRequest")

    @ResponsePayload
    public SumarResponse dameSuma(@RequestPayload SumarRequest peticion) {
        SumarResponse respuesta = new SumarResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt(peticion.getA()) + 
            Integer.parseInt(peticion.getB())
        ));
        return respuesta;
    }

    @ResponsePayload
    public RestarResponse dameResta(@RequestPayload RestarRequest peticion){
        RestarResponse respuesta = new RestarResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt(peticion.getA()) -
            Integer.parseInt(peticion.getB())
        ));
        return respuesta;
    }

    @ResponsePayload
    public MultiplicarResponse dameResta(@RequestPayload MultiplicarRequest peticion){
        MultiplicarResponse respuesta = new MultiplicarResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt(peticion.getA()) *
            Integer.parseInt(peticion.getB())
        ));
        return respuesta;
    }
    @ResponsePayload
    public DividirResponse dameDivision(@RequestPayload DividirRequest peticion){
        DividirResponse respuesta = new DividirResponse();
        respuesta.setResultado(String.valueOf(
            Integer.parseInt(peticion.getA()) /
            Integer.parseInt(peticion.getB())
        ));
        return respuesta;
    }
}
