package com.catalogo.repository;

import com.catalogo.model.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FilmeRepository {

    private final List<Filme> filmes = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public FilmeRepository() {
        filmes.add(new Filme(contador.getAndIncrement(), "O Poderoso Chefão", "Francis Ford Coppola", 1972, "Drama"));
        filmes.add(new Filme(contador.getAndIncrement(), "Interestelar", "Christopher Nolan", 2014, "Ficção Científica"));
        filmes.add(new Filme(contador.getAndIncrement(), "Parasita", "Bong Joon-ho", 2019, "Suspense"));
    }

    public List<Filme> listarTodos() {
        return new ArrayList<>(filmes);
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmes.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Filme salvar(Filme filme) {
        filme.setId(contador.getAndIncrement());
        filmes.add(filme);
        return filme;
    }

    public Optional<Filme> atualizar(Long id, Filme dados) {
        return buscarPorId(id).map(filme -> {
            filme.setTitulo(dados.getTitulo());
            filme.setDiretor(dados.getDiretor());
            filme.setAnoLancamento(dados.getAnoLancamento());
            filme.setGenero(dados.getGenero());
            filme.setNota(dados.getNota());
            return filme;
        });
    }

    public boolean deletar(Long id) {
        return filmes.removeIf(f -> f.getId().equals(id));
    }
}
