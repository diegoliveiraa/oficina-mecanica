package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculo;
import com.diegoliveiraa.oficina_mecanica.repositories.VeiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepositorio repositorio;

    public Veiculo criarVeiculo(VeiculoDTO data){
        Veiculo novoVeiculo = new Veiculo(data);
        this.salvarVeiculo(novoVeiculo);
        return novoVeiculo;
    }

    public void salvarVeiculo(Veiculo veiculo) {

        this.repositorio.save(veiculo);
    }

    public List<Veiculo> buscarTodosVeiculos(){

        return this.repositorio.findAll();
    }

    public Veiculo atualizarVeiculo(VeiculoDTO atualizarVeiculo) {
        Veiculo veiculoAtualizado = repositorio.getReferenceById(atualizarVeiculo.id());
        veiculoAtualizado.setPlaca(atualizarVeiculo.placa());
        veiculoAtualizado.setModelo(atualizarVeiculo.modelo());
        veiculoAtualizado.setQuilometragem(atualizarVeiculo.quilometragem());



        repositorio.save(veiculoAtualizado);

        return (veiculoAtualizado);
    }

    public Veiculo buscarVeiculoPorId(UUID id) throws Exception {
        return this.repositorio.findVeiculoById(id).orElseThrow(() -> new Exception("Veiculo não encontrada"));
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) throws Exception {
        return this.repositorio.findVeiculoByPlaca(placa).orElseThrow(()-> new Exception("Veiculo nao encontrado"));
    }

}
