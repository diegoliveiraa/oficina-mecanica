package com.diegoliveiraa.oficina_mecanica.controllers;

import com.diegoliveiraa.oficina_mecanica.dtos.PecaDTO;
import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Pecas;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculos;
import com.diegoliveiraa.oficina_mecanica.services.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    @PostMapping
    public ResponseEntity<Pecas> criarPeca(@RequestBody PecaDTO peca){
        Pecas novaPeca = pecaService.criarPeca(peca);
        return new ResponseEntity<>(novaPeca, HttpStatus.CREATED);

    }

    @RequestMapping
    public  ResponseEntity<List<Pecas>> buscarTodasPecas(){
        List<Pecas> todasPecas = this.pecaService.buscarTodasPecas();
        return new ResponseEntity<>(todasPecas, HttpStatus.OK);
    }

    @PostMapping("/atualizar-pecas")
    public ResponseEntity<Pecas> atualizarDadosPeca(@RequestBody PecaDTO peca){
        Pecas pecaAtualizada = pecaService.atualizarPeca(peca);
        return new ResponseEntity<>(pecaAtualizada, HttpStatus.OK);
    }
}
