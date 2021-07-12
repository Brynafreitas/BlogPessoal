package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	public Usuario usuario;
	public Usuario usuarioErro;
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@BeforeEach
	
	public void start() {
		usuario = new Usuario(0L,"Bruna","bruna_","testando2","bruninha13@gmail.com");
		usuarioErro = new Usuario();
		
		}
	
	@Test
	public void testValidationAtributos () {
		
		usuario.setNome("Bruna de Freitas");
		usuario.setUsuario("bruninh_a");
		usuario.setSenha("testando123");
		usuario.setEmail("bruna13@email.com");
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
		
		
		System.out.println(violations.toString());
		
		assertTrue(violations.isEmpty()); 
		
	}

	
	@Test
	public void testValidationAtributosNull () {
		
		usuarioErro.setEmail("bruna_@hotmail.com");
		
		Set<ConstraintViolation<Usuario>> violations = validator.validate(usuarioErro);
		
		System.out.println(violations.toString());
		
		assertFalse(violations.isEmpty());  
		
	}
	

}
