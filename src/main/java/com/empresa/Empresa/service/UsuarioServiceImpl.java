package com.empresa.Empresa.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Usuario;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> implements IUsuarioService
{
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	public UsuarioServiceImpl(IBaseRepository<Usuario, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario usuarioDisponibleService(String usuario, String contra) throws Exception {
		// 
		try 
		{
			if( !usuario.equals("") && !contra.equals("") )
			{
				return iUsuarioRepository.accederSistemaRepository(usuario, contra);
			}
			 throw new Exception("error");
			
		}
		catch( Exception e) 
		{
			throw new Exception(e.getMessage());
		}
		
	}

}
