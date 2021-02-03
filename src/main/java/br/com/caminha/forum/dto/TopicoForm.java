package br.com.caminha.forum.dto;

import br.com.caminha.forum.modelo.Curso;
import br.com.caminha.forum.modelo.Topico;
import br.com.caminha.forum.repository.CursoRepository;

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico toTopico(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(this.titulo, this.mensagem, curso);
    }
}
