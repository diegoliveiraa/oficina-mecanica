package com.diegoliveiraa.oficina_mecanica.repositories;

import com.diegoliveiraa.oficina_mecanica.entity.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentacaoEstoqueRepositorio extends JpaRepository<MovimentacaoEstoque, UUID> {
}
