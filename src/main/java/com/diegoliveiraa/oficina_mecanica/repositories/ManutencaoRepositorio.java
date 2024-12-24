package com.diegoliveiraa.oficina_mecanica.repositories;

import com.diegoliveiraa.oficina_mecanica.entity.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManutencaoRepositorio extends JpaRepository<Manutencao, UUID> {

    Optional<Manutencao> findManutencaoById(UUID id);
}
