package com.diegoliveiraa.oficina_mecanica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "veiculoId")
    private Veiculo veiculo;

    @JsonIgnoreProperties("manutencao")
    @OneToMany(mappedBy = "manutencao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManutencaoPeca> manutencaoPecas = new ArrayList<>();

    private String descricao;

    private LocalDateTime data;

    public Manutencao(UUID id, Veiculo veiculo, List<ManutencaoPeca> manutencaoPecas, String descricao) {
        this.id = id;
        this.veiculo = veiculo;
        this.manutencaoPecas = manutencaoPecas;
        this.descricao = descricao;
    }

    public Manutencao() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<ManutencaoPeca> getManutencaoPecas() {
        return manutencaoPecas;
    }

    public void setManutencaoPecas(List<ManutencaoPeca> manutencaoPecas) {
        this.manutencaoPecas = manutencaoPecas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Manutencao)) return false;
        final Manutencao other = (Manutencao) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Manutencao;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}
