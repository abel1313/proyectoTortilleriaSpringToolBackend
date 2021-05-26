package com.empresa.Empresa.module;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table( name = "productos" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto extends Base
{
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "este campo no debe ser nullo" )
	@Size(min = 1, max = 25)
	@Pattern( regexp = "[a-zA-Z ]{1,25}", message = "Solo letras" )
	private String nombreProducto;
	
	@NotNull( message = "este campo no debe ser nullo" )
	@Min( value = 1, message = "Ingrese solo numeros")
	@Pattern( regexp = "^[0-9]+([.][0-9]{1,2})?$", message = "El digito no es valido" )
	private double precioProducto;
	
	@NotNull( message = "este campo no debe ser nullo" )
	@Min( value = 1, message = "Ingrese solo numeros")
	@Pattern( regexp = "^[0-9]+([.][0-9]{1,2})?$", message = "El digito no es valido" )
	private double disponibilidadProducto;
	

}
