package com.diegoliveiraa.oficina_mecanica.repositories;

import com.diegoliveiraa.oficina_mecanica.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VeiculoRepositorio extends JpaRepository<Veiculo, UUID> {
    Optional<Veiculo> findVeiculoById(UUID id);
    Optional<Veiculo> findVeiculoByPlaca(String placa);

}
