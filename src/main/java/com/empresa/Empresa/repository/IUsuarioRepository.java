package com.empresa.Empresa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empresa.Empresa.module.Usuario;

@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Integer>
{

	@Query
	( value = "SELECT id, contrasena_usuario, nombre_usuario FROM usuarios "
			+ "WHERE nombre_usuario = :nombreUsuario AND contrasena_usuario = :contraUsuario", 
			nativeQuery = true )
	public Usuario accederSistemaRepository
	( @Param("nombreUsuario") String  nombreUsuario, @Param("contraUsuario") String contraUsuario );
}
