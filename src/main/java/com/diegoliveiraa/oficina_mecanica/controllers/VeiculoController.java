package com.diegoliveiraa.oficina_mecanica.controllers;

import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculo;
import com.diegoliveiraa.oficina_mecanica.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody VeiculoDTO veiculo){
        Veiculo novoVeiculo = veiculoService.criarVeiculo(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> buscarTodos(){
        List<Veiculo> veiculos = this.veiculoService.buscarTodosVeiculos();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }

    @GetMapping("/buscar-veiculo")
    public ResponseEntity<Veiculo> buscarPorId(@RequestParam UUID id) throws Exception {

        Veiculo veiculo = this.veiculoService.buscarVeiculoPorId(id);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @PostMapping("/atualizar-veiculo")
    public ResponseEntity<Veiculo> atualizarDadosVeiculo(@RequestBody VeiculoDTO atualizarVeiculo){
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(atualizarVeiculo);
        return new ResponseEntity<>(veiculoAtualizado, HttpStatus.OK);
    }

    @GetMapping("/buscar-placa")
    public ResponseEntity<Veiculo> buscarPorPlaca(@RequestParam String placa) throws Exception {

        Veiculo veiculo = this.veiculoService.buscarVeiculoPorPlaca(placa);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }
}