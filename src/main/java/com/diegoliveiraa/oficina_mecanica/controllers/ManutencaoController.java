package com.diegoliveiraa.oficina_mecanica.controllers;

import com.diegoliveiraa.oficina_mecanica.dtos.ManutencaoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Manutencao;
import com.diegoliveiraa.oficina_mecanica.services.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {
    @Autowired
    private ManutencaoService manutencaoService;

    @PostMapping
    public ResponseEntity<Manutencao> criarManutencao(@RequestBody ManutencaoDTO manutencao) throws Exception {
        Manutencao novaManutencao = manutencaoService.criarManutencao(manutencao);
        return new ResponseEntity<>(novaManutencao, HttpStatus.CREATED);

    }

    @RequestMapping
    public  ResponseEntity<List<Manutencao>> buscarTodasManutencoes(){
        List<Manutencao> todasManutencoes = this.manutencaoService.bucasTodasManutencoes();
        return new ResponseEntity<>(todasManutencoes, HttpStatus.OK);
    }

}
