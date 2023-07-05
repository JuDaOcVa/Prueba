package com.example.prueba.controller;

import com.example.prueba.services.PruebaServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerPrueba {
    public final PruebaServices pruebaServices;

    public controllerPrueba(PruebaServices pruebaServices) {
        this.pruebaServices = pruebaServices;
    }

    @PostMapping("/consultar")
    public String pruebaMamalona(@RequestParam(name = "xd") String numeros) {
        return  pruebaServices.consultar(numeros);
    }
}
