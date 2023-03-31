package edu.mfvp.designpatternspring.repository;

import edu.mfvp.designpatternspring.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
