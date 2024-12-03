package com.diegoliveiraa.oficina_mecanica.entity;

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
    private BigDecimal estoqueInicial;
    private LocalDateTime data;

}
