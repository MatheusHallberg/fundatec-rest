package br.com.fundatec.carro.api;

import br.com.fundatec.carro.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;

    public CarroApi(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("carros")
    public ResponseEntity<List<String>> getCarro() {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(carroService.listarCarros());
        return responseEntity;
    }
}
