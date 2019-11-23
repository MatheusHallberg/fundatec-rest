package br.com.fundatec.carro.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CarroApi {

    @GetMapping("carros")
    public List<String> getCarro() {
        List<String> carros = Arrays.asList("Mustang", "Camaro", "Uno", "Celta");
        return carros;
    }
}
