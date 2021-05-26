package com.empresa.Empresa.service;

import com.empresa.Empresa.module.Usuario;

public interface IUsuarioService extends IBaseService<Usuario, Integer>
{
	
	public Usuario usuarioDisponibleService( String usuario, String contra) throws Exception;

}
