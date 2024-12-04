package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.dtos.ManutencaoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Manutencoes;
import com.diegoliveiraa.oficina_mecanica.entity.MovimentacaoEstoque;
import com.diegoliveiraa.oficina_mecanica.entity.Pecas;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculos;
import com.diegoliveiraa.oficina_mecanica.repositories.ManutencoesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {
    @Autowired
    public VeiculoService veiculoService;
    @Autowired
    public PecaService pecaService;
    @Autowired
    public MovimentacaoEstoqueService movimentacaoEstoqueService;
    @Autowired
    private ManutencoesRepositorio repositorio;



}
