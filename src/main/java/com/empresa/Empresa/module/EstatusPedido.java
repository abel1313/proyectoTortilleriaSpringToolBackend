package com.empresa.Empresa.module;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "estatuspedidos" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EstatusPedido extends Base
{
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String nombreEstatusPedido;
	
	@NotNull( message = "Este campo no debe ir vacío" )
	@Size( min = 1, max = 25)
	private String descripccion;
	

}
