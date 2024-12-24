package com.diegoliveiraa.oficina_mecanica.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ManutencaoDTO(UUID id, UUID veiculoId, List<PecaUsadaDTO> pecas, String descricao, LocalDateTime data) {
}
