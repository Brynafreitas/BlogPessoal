package org.generation.blogPessoal.service;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository repository;

	private Postagem buscarPostagemporId(Long id) {

		Postagem buscapostagem = repository.findById(id).orElse(null);

		if (buscapostagem != null) {

			return buscapostagem;

		} else {

			throw new EmptyResultDataAccessException(1);
		}

	}

	public Postagem curtir(Long id) {

		Postagem postagem = buscarPostagemporId(id);

		postagem.setCurtidas(postagem.getCurtidas() + 1);

		return repository.save(postagem);
	}

	public Postagem descurtir(Long id) {

		Postagem postagem = buscarPostagemporId(id);

		if (postagem.getCurtidas() > 0) {
			postagem.setCurtidas(postagem.getCurtidas() - 1);
		} else {
			postagem.setCurtidas(0);
		}

		return repository.save(postagem);

	}

	
}
