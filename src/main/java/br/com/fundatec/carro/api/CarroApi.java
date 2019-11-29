package br.com.fundatec.carro.api;

import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;

    public CarroApi(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/carros")
    public ResponseEntity<List<CarroOutputDto>> getCarro(@RequestParam(required = false, defaultValue = "") String nome) {
        List<Carro> carros = (carroService.listarCarros(nome));
        if (carros.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        List<CarroOutputDto> carrosOutputDto = new ArrayList<>();
        for (Carro carro : carros) {
            carrosOutputDto.add(converter(carro));
        }
        return ResponseEntity.ok(carrosOutputDto);
    }

    private CarroOutputDto converter(Carro carro) {
        CarroOutputDto carroOutputDto = new CarroOutputDto();
        carroOutputDto.setId(carro.getId());
        carroOutputDto.setNome(carro.getNome());
        return carroOutputDto;
    }

    @GetMapping("/carros/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id) {
        Carro carro = carroService.consultar(id);
        if (carro == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carro);
    }
}
