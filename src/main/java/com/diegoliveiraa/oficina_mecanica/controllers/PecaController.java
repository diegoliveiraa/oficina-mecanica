package com.diegoliveiraa.oficina_mecanica.controllers;

import com.diegoliveiraa.oficina_mecanica.dtos.PecaDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Peca;
import com.diegoliveiraa.oficina_mecanica.services.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    @PostMapping
    public ResponseEntity<Peca> criarPeca(@RequestBody PecaDTO peca){
        Peca novaPeca = pecaService.criarPeca(peca);
        return new ResponseEntity<>(novaPeca, HttpStatus.CREATED);

    }

    @PostMapping("/atualizar-pecas")
    public ResponseEntity<Peca> atualizarDadosPeca(@RequestBody PecaDTO peca){
        Peca pecaAtualizada = pecaService.atualizarPeca(peca);
        return new ResponseEntity<>(pecaAtualizada, HttpStatus.OK);
    }

    @RequestMapping
    public  ResponseEntity<List<Peca>> buscarTodasPecas(){
        List<Peca> todasPecas = this.pecaService.buscarTodasPecas();
        return new ResponseEntity<>(todasPecas, HttpStatus.OK);
    }

    @RequestMapping("/buscar-peca")
    public ResponseEntity<Peca> buscarPecaId(@RequestParam UUID id) throws Exception {

        Peca peca = this.pecaService.buscarPecasPorId(id);
        return new ResponseEntity<>(peca, HttpStatus.OK);
    }
}
