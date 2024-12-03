package com.diegoliveiraa.oficina_mecanica.controllers;

import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculos;
import com.diegoliveiraa.oficina_mecanica.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;
    @PostMapping
    public ResponseEntity<Veiculos> criarVeiculo(@RequestBody VeiculoDTO veiculo){
        Veiculos novoVeiculo = veiculoService.criarVeiculo(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veiculos>> buscarTodosVeiculos(){
        List<Veiculos> veiculos = this.veiculoService.buscarTodosVeiculos();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @PostMapping("/atualizar-veiculo")
    public ResponseEntity<Veiculos> atualizarDadosVeiculo(@RequestBody VeiculoDTO atualizarVeiculo){
        Veiculos veiculoAtualizado = veiculoService.atualizarVeiculo(atualizarVeiculo);
        return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
    }
}
