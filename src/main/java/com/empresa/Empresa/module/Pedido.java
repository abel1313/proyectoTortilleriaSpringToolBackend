package com.empresa.Empresa.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "pedidos" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pedido extends Base
{
	private static final long serialVersionUID = 1L;
	
	@OneToOne( cascade = CascadeType.ALL, optional = false)
	@JoinColumn( name = "venta_Id", nullable = false)
	private Venta venta;
	
	@OneToOne( cascade = CascadeType.ALL, optional = false)
	@JoinColumn( name = "usuario_Id", nullable = false)
	private Usuario usuario;
	
	@OneToOne( cascade = CascadeType.ALL, optional = false)
	@JoinColumn( name = "estatusPedido_Id", nullable = false)
	private EstatusPedido estatusPedido;
	

}
