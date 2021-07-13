package org.generation.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private Usuario usuario;
	private Usuario usuarioUpdate;

	@BeforeAll
	public void start() {

		usuario = new Usuario(0L, "Admin", "admin_", "admin123", "admin@email.com");
		usuarioUpdate = new Usuario(4L, "Bruna de Freitas", "brun4_", "7654128", "brunafreitas@email.com");

	}

	@Disabled
	@Test
	public void deveCadastrarNovoUsuario() {
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuario);

		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, requisicao,
				Usuario.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());

	}

	@Disabled
	@Test
	public void deveMostrarTodosUsuarios() {

<<<<<<< HEAD
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("admin_", "admin123")
=======
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("brun4_", "7654128")
>>>>>>> 245410a3d1ccf1b92f55612d110810726c494562
				.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

	
	@Test
	public void deveAlterarUsuaario() {
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuarioUpdate);
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("admin_", "admin123")
				.exchange("/usuarios/alterar", HttpMethod.PUT, requisicao, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}
