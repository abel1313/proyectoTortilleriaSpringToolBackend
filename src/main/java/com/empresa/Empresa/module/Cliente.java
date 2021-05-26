package com.empresa.Empresa.module;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "clientes" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Base
{
	private static final long serialVersionUID = 1L;
	
	@OneToOne( cascade = CascadeType.ALL, optional = false)
	@JoinColumn( name = "persona_Id", nullable = false )
	private Persona persona;

	@OneToOne( cascade = CascadeType.ALL, optional = false)
	@JoinColumn( name = "usuario_Id", nullable = false )
	private Usuario usuario;
}
