package br.com.fundatec.carro.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CarroRepository {

    public List<String> listarCarros(String nome) {
        List<String> carros = Arrays.asList("Mustang",
                "Camaro",
                "Uno",
                "Celta");

        List<String> listaResultado = new ArrayList<>();

        for(String carro: carros) {
            if (carro.toLowerCase().contains(nome.toLowerCase())) {
                listaResultado.add(carro);
            }
        }
        return listaResultado;
    }

}
