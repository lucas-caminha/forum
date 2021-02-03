package br.com.caminha.forum.repository;

import br.com.caminha.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findAll();

    List<Topico> findByCursoNome(String nomeCurso);

}
