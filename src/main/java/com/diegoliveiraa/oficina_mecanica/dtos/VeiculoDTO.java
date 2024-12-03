package com.diegoliveiraa.oficina_mecanica.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record VeiculoDTO(UUID id, String placa, String modelo, BigDecimal quilometragem) {
}
