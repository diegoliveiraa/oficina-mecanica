package com.diegoliveiraa.oficina_mecanica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "manutencoes")
@Table(name = "manutencoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Manutencoes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "vaiculoId")
    private Veiculos veiculo;
    private LocalDateTime data;
    private String descricao;
    @ManyToMany
    @JoinColumn(name = "pecasId")
    private Pecas peca;
}
