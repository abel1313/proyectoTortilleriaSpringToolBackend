package com.empresa.Empresa.module;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "usuarios" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario extends Base
{
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String nombreUsuario;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 255)
	private String contrasenaUsuario;
	
	
	public String getUsuarioExistente()
	{
		return nombreUsuario;
	}

}
