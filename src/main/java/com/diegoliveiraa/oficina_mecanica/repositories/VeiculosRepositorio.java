package com.diegoliveiraa.oficina_mecanica.repositories;

import com.diegoliveiraa.oficina_mecanica.entity.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VeiculosRepositorio extends JpaRepository<Veiculos, UUID> {
}
