package com.diegoliveiraa.oficina_mecanica.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record PecaDTO(UUID id, String codigoBarras, String nome, String categoria, String fornecedor, BigDecimal precoUnitario, BigDecimal quantidade) {
}
