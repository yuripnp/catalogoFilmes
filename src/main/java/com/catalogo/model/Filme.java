package com.catalogo.model;

public class Filme {

    private Long id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private double nota;

    public Filme() {}

    public Filme(Long id, 
        String titulo, 
        String diretor, 
        int anoLancamento, 
        String genero) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getNota() { return nota; }
    public void setNota(double nota) {
        if (nota < 0 || nota > 5.0) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 5.0");
        }
        this.nota = nota;
    }

    public void exibirFichaTecnica() {
        System.out.println("========== FICHA TÉCNICA ==========");
        System.out.println("ID:               " + getId());
        System.out.println("Título:           " + getTitulo());
        System.out.println("Diretor:          " + getDiretor());
        System.out.println("Ano de lançamento:" + getAnoLancamento());
        System.out.println("Gênero:           " + getGenero());
        System.out.println("Nota:             " + getNota() + " / 5.0");
        System.out.println("===================================");
    }
}
