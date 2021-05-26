package com.empresa.Empresa.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "personas" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona extends Base
{
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String nombrePersona;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String paternoPersona;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String maternoPersona;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String telefonoPersona;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	@Pattern( regexp = "[a-zA-Z0-9!#$%&'*_+-]([\\\\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\\\\/()=?¿!.,:;]|\\\\d)+[a-zA-Z0-9][\\\\.][a-zA-Z]{2,4}([\\\\.][a-zA-Z]{2})?" )
	private String correoPersona;
	
	@OneToOne( cascade = CascadeType.ALL, optional = false )
	@JoinColumn( name = "direccion_Id", nullable = false)
	private Direccion direccion;
	

	// [a-z]+@[a-z]+.[a-z]{1,3} email echo por mi xD
	// ^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$ correo viend
	// [a-zA-Z0-9!#$%&'*_+-]([\\\\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\\\\/()=?¿!.,:;]|\\\\d)+[a-zA-Z0-9][\\\\.][a-zA-Z]{2,4}([\\\\.][a-zA-Z]{2})? tambien funciona
	
}
