package com.catalogo.service;

import com.catalogo.model.Filme;
import com.catalogo.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<Filme> listarTodos() {
        return repository.listarTodos();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Filme adicionar(Filme filme) {
        return repository.salvar(filme);
    }

    public Optional<Filme> atualizar(Long id, Filme dados) {
        return repository.atualizar(id, dados);
    }

    public boolean deletar(Long id) {
        return repository.deletar(id);
    }
}
