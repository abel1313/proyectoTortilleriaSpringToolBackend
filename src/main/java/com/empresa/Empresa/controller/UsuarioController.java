package com.empresa.Empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.Empresa.module.Usuario;
import com.empresa.Empresa.repository.IUsuarioRepository;
import com.empresa.Empresa.service.IUsuarioService;
import com.empresa.Empresa.service.UsuarioServiceImpl;

@RestController
@RequestMapping(path = "/empresa/sistema/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>
{
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@PostMapping(value = "/acceder",  consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> acceder( @RequestBody Usuario usuario   ) {
		try {

			String nombreUsuario = usuario.getNombreUsuario();
			String contra = usuario.getContrasenaUsuario();
			
			
			if( !nombreUsuario.equals("") && !contra.equals("")  )
			{
				Usuario us =  iUsuarioService.usuarioDisponibleService(nombreUsuario, contra);
				return us != null ? 
						ResponseEntity.status(HttpStatus.OK).body( iUsuarioService.usuarioDisponibleService(nombreUsuario, contra) ) :
							ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde '}");
			}
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde '}");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
}
