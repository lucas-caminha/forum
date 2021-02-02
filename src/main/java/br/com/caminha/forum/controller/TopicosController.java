package br.com.caminha.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caminha.forum.dto.TopicoDto;
import br.com.caminha.forum.modelo.Curso;
import br.com.caminha.forum.modelo.Topico;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDto> topicos(){
		Topico topico = new Topico("Dúvida","Dúvida com Spring", new Curso("Spring Boot", "Programação"));
		
		return TopicoDto.toTopicos(Arrays.asList(topico, topico, topico));
	}
}
