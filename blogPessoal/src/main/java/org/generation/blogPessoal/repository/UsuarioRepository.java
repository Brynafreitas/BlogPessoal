package org.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional <Usuario> findByEmail(String email);
	public Optional<Usuario> findByUsuario(String usuario);
	public Optional<Usuario> findFirstByNomeContainingIgnoreCaseOrderByNome(String nome);
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
		
	
}
