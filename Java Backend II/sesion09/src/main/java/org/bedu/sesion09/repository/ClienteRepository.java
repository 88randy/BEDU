package org.bedu.sesion09.repository;

import org.bedu.sesion09.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
