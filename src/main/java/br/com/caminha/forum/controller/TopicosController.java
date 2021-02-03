package br.com.caminha.forum.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import br.com.caminha.forum.dto.TopicoForm;
import br.com.caminha.forum.repository.CursoRepository;
import br.com.caminha.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.caminha.forum.dto.TopicoDto;
import br.com.caminha.forum.modelo.Curso;
import br.com.caminha.forum.modelo.Topico;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoDto> topicos(String nomeCurso){
		List<Topico> topicos;
		if (nomeCurso == null || nomeCurso.isEmpty()){
			topicos = topicoRepository.findAll();
		} else {
			topicos = topicoRepository.findByCursoNome(nomeCurso);
		}

		return TopicoDto.toTopicos(topicos);
	}

	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder){
		Topico topico = form.toTopico(cursoRepository);
		topicoRepository.save(topico);

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
}
