package com.diegoliveiraa.oficina_mecanica.repositories;

import com.diegoliveiraa.oficina_mecanica.entity.Manutencoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManutencoesRepositorio extends JpaRepository<Manutencoes, UUID> {
}
