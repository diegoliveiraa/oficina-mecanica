package com.diegoliveiraa.oficina_mecanica.entity;

import com.diegoliveiraa.oficina_mecanica.dtos.ManutencaoDTO;
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
    @ManyToMany
    @JoinColumn(name = "pecasId")
    private Pecas peca;
    private String descricao;
    private LocalDateTime data;

    public Manutencoes(ManutencaoDTO data){
        this.veiculo = data.veiculoId();
        this.peca = data.pecaId();
        this.descricao = data.descricao();
    }
}
