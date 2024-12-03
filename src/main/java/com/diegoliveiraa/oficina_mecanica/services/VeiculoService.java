package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculos;
import com.diegoliveiraa.oficina_mecanica.repositories.VeiculosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculosRepositorio repositorio;

    public Veiculos criarVeiculo(VeiculoDTO data){
        Veiculos novoVeiculo = new Veiculos(data);
        this.salvarVeiculo(novoVeiculo);
        return novoVeiculo;
    }

    public void salvarVeiculo(Veiculos veiculo) {
        this.repositorio.save(veiculo);
    }

    public List<Veiculos> buscarTodosVeiculos(){
        return this.repositorio.findAll();
    }

    public Veiculos atualizarVeiculo(VeiculoDTO atualizarVeiculo) {
        Veiculos veiculoAtualizado = repositorio.getReferenceById(atualizarVeiculo.id());
        veiculoAtualizado.setPlaca(atualizarVeiculo.placa());
        veiculoAtualizado.setModelo(atualizarVeiculo.modelo());
        veiculoAtualizado.setQuilometragem(atualizarVeiculo.quilometragem());

        repositorio.save(veiculoAtualizado);

        return (veiculoAtualizado);
    }
}
