package com.diegoliveiraa.oficina_mecanica.entity;

import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String placa;
    private String modelo;
    private BigDecimal quilometragem;

    public Veiculo(VeiculoDTO data) {
        this.placa = data.placa();
        this.modelo = data.modelo();
        this.quilometragem = data.quilometragem();
    }

    public Veiculo(UUID id, String placa, String modelo, BigDecimal quilometragem) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
    }

    public Veiculo() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public BigDecimal getQuilometragem() {
        return this.quilometragem;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setQuilometragem(BigDecimal quilometragem) {
        this.quilometragem = quilometragem;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Veiculo)) return false;
        final Veiculo other = (Veiculo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Veiculo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}
