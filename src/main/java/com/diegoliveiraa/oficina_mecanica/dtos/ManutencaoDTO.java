package com.diegoliveiraa.oficina_mecanica.dtos;

import com.diegoliveiraa.oficina_mecanica.entity.Pecas;
import com.diegoliveiraa.oficina_mecanica.entity.Veiculos;

import java.util.List;
import java.util.UUID;

public record ManutencaoDTO(UUID veiculoId, List<UUID> pecaId, String descricao) {
}
