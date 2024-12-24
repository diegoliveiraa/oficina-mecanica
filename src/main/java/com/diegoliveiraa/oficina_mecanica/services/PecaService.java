package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.dtos.PecaDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Peca;
import com.diegoliveiraa.oficina_mecanica.repositories.PecaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PecaService {

    @Autowired
    private PecaRepositorio repositorio;

    public Peca criarPeca(PecaDTO data){
        Peca novaPeca = new Peca(data);
        this.salvarPeca(novaPeca);
        return novaPeca;
    }

    public void salvarPeca(Peca novaPeca) {

        this.repositorio.save(novaPeca);
    }

    public List<Peca> buscarTodasPecas(){

        return this.repositorio.findAll();
    }

    public Peca atualizarPeca(PecaDTO atualizarPeca) {

        Peca pecaAtualizada = repositorio.getReferenceById(atualizarPeca.id());
        pecaAtualizada.setNome(atualizarPeca.nome());
        pecaAtualizada.setCategoria(atualizarPeca.categoria());
        pecaAtualizada.setFornecedor(atualizarPeca.fornecedor());
        pecaAtualizada.setPrecoUnitario(atualizarPeca.precoUnitario());
        pecaAtualizada.setQuantidade(atualizarPeca.quantidade());


        repositorio.save(pecaAtualizada);

        return (pecaAtualizada);
    }

    public List<Peca> buscarListaPecasPorId(List<UUID> id) throws Exception {
        return this.repositorio.findByIdIn(id);
    }

    public Peca buscarPecasPorId(UUID id) throws Exception {
        return this.repositorio.findById(id).orElseThrow(() -> new Exception("Peça não encontrada"));
    }
}
