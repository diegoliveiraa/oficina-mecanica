package com.diegoliveiraa.oficina_mecanica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "movimentacaoEstoque")
@Table(name = "movimentacaoEstoque")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "pecaId")
    private Pecas peca;
    private MovimentacaoTipo entrada;
    private MovimentacaoTipo saida;
    private BigDecimal quantidade;
    private LocalDateTime dataMovimentacao;
    private BigDecimal precoUnitario;

}
