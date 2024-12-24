package com.diegoliveiraa.oficina_mecanica.services;

import com.diegoliveiraa.oficina_mecanica.dtos.ManutencaoDTO;
import com.diegoliveiraa.oficina_mecanica.dtos.PecaUsadaDTO;
import com.diegoliveiraa.oficina_mecanica.entity.ManutencaoPeca;
import com.diegoliveiraa.oficina_mecanica.entity.Manutencao;
import com.diegoliveiraa.oficina_mecanica.entity.Peca;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculo;
import com.diegoliveiraa.oficina_mecanica.repositories.ManutencaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManutencaoService {

    @Autowired
    public VeiculoService veiculoService;
    @Autowired
    public PecaService pecaService;
    @Autowired
    private ManutencaoRepositorio repositorio;

    public Manutencao criarManutencao(ManutencaoDTO data) throws Exception {

        Veiculo veiculo = this.veiculoService.buscarVeiculoPorId(data.veiculoId());
        atualizarPecasUsadas(data.pecas());

        Manutencao novaManutencao = new Manutencao();
        novaManutencao.setVeiculo(veiculo);
        novaManutencao.setDescricao(data.descricao());
        novaManutencao.setData(LocalDateTime.now());

        List<ManutencaoPeca> manutencaoPecas = data.pecas().stream().map(pecaUsadaDTO -> {
                    Peca peca = null;
                    try {
                        peca = pecaService.buscarPecasPorId(pecaUsadaDTO.pecaId());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    ManutencaoPeca manutencaoPeca = new ManutencaoPeca();
            manutencaoPeca.setManutencao(novaManutencao);
            manutencaoPeca.setPeca(peca);
            manutencaoPeca.setQuantidadeUsada(pecaUsadaDTO.quantidadeUsada());

            return manutencaoPeca;
        })
                .collect(Collectors.toList());

        novaManutencao.setManutencaoPecas(manutencaoPecas);

        System.out.println(novaManutencao);

        this.salvarManutencao(novaManutencao);

        return novaManutencao;
    }

    public List<Peca> atualizarPecasUsadas(List<PecaUsadaDTO> pecasData) throws Exception {

        List<Peca> pecaUsadas = new ArrayList<>();

        for (PecaUsadaDTO pecaData : pecasData) {

            Peca peca = this.pecaService.buscarPecasPorId(pecaData.pecaId());

            if (peca.getQuantidade() < pecaData.quantidadeUsada()) {
                throw new IllegalArgumentException("Quantidade insuficiente para a peça: " + peca.getNome());
            }

            peca.setQuantidade(peca.getQuantidade() - pecaData.quantidadeUsada());

            this.pecaService.salvarPeca(peca);


            pecaUsadas.add(peca);
        }

        return pecaUsadas;
    }

    public void salvarManutencao(Manutencao data){
        this.repositorio.save(data);
    }

    public List<Manutencao> bucasTodasManutencoes(){
        return this.repositorio.findAll();
    }

    public Manutencao buscarManutencaoPorId(UUID id) throws Exception {
        return this.repositorio.findManutencaoById(id).orElseThrow(()-> new Exception("Manutencao nao encontrada"));
    }

}
