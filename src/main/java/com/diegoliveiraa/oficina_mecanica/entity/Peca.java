package com.diegoliveiraa.oficina_mecanica.entity;

import com.diegoliveiraa.oficina_mecanica.dtos.PecaDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "peca")
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String codigoBarras;
    private String nome;
    private String categoria;
    private String fornecedor;
    private BigDecimal precoUnitario;
    private int quantidade;

    @OneToMany(mappedBy = "peca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManutencaoPeca> manutencaoPecas = new ArrayList<>();

    private LocalDateTime data;

   public Peca(UUID id, String codigoBarras, String nome, String categoria, String fornecedor, BigDecimal precoUnitario, int quantidade, LocalDateTime data) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.data = LocalDateTime.now();
    }

    public Peca() {
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Peca(PecaDTO data) {
        this.codigoBarras = data.codigoBarras();
        this.nome = data.nome();
        this.categoria = data.categoria();
        this.fornecedor = data.fornecedor();
        this.precoUnitario = data.precoUnitario();
        this.quantidade = data.quantidade();
        this.data = LocalDateTime.now();
    }

   public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Peca)) return false;
        final Peca other = (Peca) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Peca;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}
