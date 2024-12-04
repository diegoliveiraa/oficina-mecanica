package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.entity.Pecas;
import com.diegoliveiraa.oficina_mecanica.repositories.MovimentacaoEstoqueRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovimentacaoEstoqueService{
    @Autowired
    private MovimentacaoEstoqueRepositorio repositorio;


}
