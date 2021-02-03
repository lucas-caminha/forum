package br.com.caminha.forum.repository;

import br.com.caminha.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAll();

    Curso findByNome(String nome);

}
