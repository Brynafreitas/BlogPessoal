package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@BeforeAll
	public void start() {
		Usuario usuario = new Usuario(0L, "Jonathan Silva", "jonathanzika", "zikabalad4", "souzika@email.com");
		if (repository.findByEmail(usuario.getEmail()).isEmpty())
			repository.save(usuario);

		usuario = new Usuario(0L, "Luis Henrique", "rique_fritas", "1234567", "riqueairfryers@email.com");
		if (repository.findByEmail(usuario.getEmail()).isEmpty())
			repository.save(usuario);

		usuario = new Usuario(0L, "Danny Bond", "Danny_bond", "879456", "danitenho@email.com");
		if (repository.findByEmail(usuario.getEmail()).isEmpty())
			repository.save(usuario);

	}

	@Test
	public void findByEmailRetornaUsuario() {
		Optional<Usuario> usuario = repository.findByEmail("souzika@email.com");
		assertTrue(usuario.get().getEmail().equals("souzika@email.com"));

	}

	@Test
	public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {
		List<Usuario> usuarios = repository.findAllByNomeContainingIgnoreCase("Jonathan");

		assertEquals(3, usuarios.size());
	}

	@Test
	public void findByNomeOrderByNomeRetornaUsuario() {
		Optional<Usuario> usuarioNome = repository.findFirstByNomeContainingIgnoreCaseOrderByNome("Danny");

		assertTrue(usuarioNome.get().getNome().equals("Danny Bond"));

	}

	@Test
	public void findByUsuarioRetornaUsuario() {
		Optional<Usuario> usuario = repository.findByUsuario("jonathanzika");

		assertTrue(usuario.get().getUsuario().equals("jonathanzika"));
	}
}
