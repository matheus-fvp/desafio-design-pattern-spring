package edu.mfvp.designpatternspring.service;

import edu.mfvp.designpatternspring.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserirCliente(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);

}
