package com.empresa.Empresa.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "mensajes" )
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Mensaje extends Base
{

	private static final long serialVersionUID = 1L;
	
	@Column( name = "nombre_mensaje" )
	@NotNull
	private String nombreMensaje;
}
