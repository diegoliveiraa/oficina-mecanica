package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.dtos.PecaDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Pecas;
import com.diegoliveiraa.oficina_mecanica.repositories.PecasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PecaService {

    @Autowired
    private PecasRepositorio repositorio;

    public Pecas criarPeca(PecaDTO data){
        Pecas novaPeca = new Pecas(data);
        this.salvarPeca(novaPeca);
        return novaPeca;
    }

    public void salvarPeca(Pecas novaPeca) {
        this.repositorio.save(novaPeca);
    }

    public List<Pecas> buscarTodasPecas(){
        return this.repositorio.findAll();
    }

    public Pecas atualizarPeca(PecaDTO atualizarPeca) {
        Pecas pecaAtualizada = repositorio.getReferenceById(atualizarPeca.id());
        pecaAtualizada.setNome(atualizarPeca.nome());
        pecaAtualizada.setCategoria(atualizarPeca.categoria());
        pecaAtualizada.setFornecedor(atualizarPeca.fornecedor());
        pecaAtualizada.setPrecoUnitario(atualizarPeca.precoUnitario());

        repositorio.save(pecaAtualizada);

        return (pecaAtualizada);
    }

    public Pecas buscarPecaPorId(UUID id) throws Exception {
        return this.repositorio.buscarPecaPorId(id).orElseThrow(() -> new Exception("Peça não encontrada"));
    }
}
