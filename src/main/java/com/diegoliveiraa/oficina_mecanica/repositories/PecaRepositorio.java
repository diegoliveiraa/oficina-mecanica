package com.diegoliveiraa.oficina_mecanica.repositories;

import com.diegoliveiraa.oficina_mecanica.entity.Peca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PecaRepositorio extends JpaRepository<Peca, UUID> {
    List<Peca> findByIdIn(List<UUID> ids);

}
