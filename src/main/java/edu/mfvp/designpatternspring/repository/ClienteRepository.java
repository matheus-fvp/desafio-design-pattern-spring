package edu.mfvp.designpatternspring.repository;

import edu.mfvp.designpatternspring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
