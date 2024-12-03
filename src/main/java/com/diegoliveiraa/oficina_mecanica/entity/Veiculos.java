package com.diegoliveiraa.oficina_mecanica.entity;

import com.diegoliveiraa.oficina_mecanica.dtos.VeiculoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "veiculos")
@Table(name = "veiculos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String placa;
    private String modelo;
    private BigDecimal quilometragem;

    public Veiculos(VeiculoDTO data) {
        this.modelo = data.modelo();
        this.placa = data.placa();
        this.quilometragem = data.quilometragem();
    }
}
