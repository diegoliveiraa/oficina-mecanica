package com.diegoliveiraa.oficina_mecanica.entity;

import com.diegoliveiraa.oficina_mecanica.dtos.PecaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "pecas")
@Table(name = "pecas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pecas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String codigoBarras;
    private String nome;
    private String categoria;
    private String fornecedor;
    private BigDecimal precoUnitario;
    private BigDecimal quantidade;
    private LocalDateTime data;

    public Pecas(PecaDTO data) {
        this.nome = data.nome();
        this.categoria = data.categoria();
        this.fornecedor = data.fornecedor();
        this.precoUnitario = data.precoUnitario();
        this.quantidade = data.quantidade();
    }
}
