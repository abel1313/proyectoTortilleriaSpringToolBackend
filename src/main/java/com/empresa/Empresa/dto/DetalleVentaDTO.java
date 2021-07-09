package com.empresa.Empresa.dto;


import com.empresa.Empresa.module.Base;
import com.empresa.Empresa.module.Producto;
import com.empresa.Empresa.module.Venta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDTO extends Base
{
	
	private static final long serialVersionUID = 1L;
	
	private double subtotalDetalleVenta;

	private double kilosDetalleVenta;
	
	private double precioDetalleVenta;
	
	private Producto producto;
	
	private Venta venta;
	
	
}
