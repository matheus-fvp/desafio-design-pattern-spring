package edu.mfvp.designpatternspring.service.impl;

import edu.mfvp.designpatternspring.model.Cliente;
import edu.mfvp.designpatternspring.model.Endereco;
import edu.mfvp.designpatternspring.repository.ClienteRepository;
import edu.mfvp.designpatternspring.repository.EnderecoRepository;
import edu.mfvp.designpatternspring.service.ClienteService;
import edu.mfvp.designpatternspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        return clienteBd.get();
    }

    @Override
    public void inserirCliente(Cliente cliente) {
        salvarClienteComEndereco(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComEndereco(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public void salvarClienteComEndereco(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
