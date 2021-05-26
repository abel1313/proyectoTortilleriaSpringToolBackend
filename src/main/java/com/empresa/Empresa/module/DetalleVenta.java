package com.empresa.Empresa.module;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "detalleventas" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta extends Base
{
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "este campo no debe ser nullo" )
	@Min( value = 1, message = "Ingrese solo números")
	@Pattern( regexp = "^[0-9]+([.][0-9])?$", message = "El digito no es valido" )
	private double subtotalDetalleVenta;
	
	@NotNull( message = "este campo no debe ser nullo" )
	@Min( value = 1, message = "Ingrese solo números")
	@Pattern( regexp = "^[0-9]+([.][0-9]{1,2})?$", message = "El digito no es valido" )
	private double kilosDetalleVenta;
	
	@NotNull( message = "este campo no debe ser nullo" )
	@Min( value = 1, message = "Ingrese solo números")
	@Pattern( regexp = "^[0-9]+([.][0-9]{1,2})?$", message = "El digito no es valido" )
	private double precioDetalleVenta;
	
	@OneToOne( cascade = CascadeType.ALL, optional = false )
	@JoinColumn( name = "producto_Id", nullable = false )
	private Producto producto;
	
	
//	@OneToOne( cascade = CascadeType.ALL, optional = false )
//	@JoinColumn( name = "venta_Id", nullable = false )
//	private Venta venta;
	

	
	

}
