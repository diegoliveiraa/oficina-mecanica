package com.diegoliveiraa.oficina_mecanica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "manutencao_peca")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManutencaoPeca {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne

    @JoinColumn(name = "manutencao_id", nullable = false)
    private Manutencao manutencao;

    @ManyToOne
    @JoinColumn(name = "peca_id", nullable = false)
    private Peca peca;

    @Column(name = "quantidade_usada", nullable = false)
    private Integer quantidadeUsada;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Integer getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(Integer quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }
}
