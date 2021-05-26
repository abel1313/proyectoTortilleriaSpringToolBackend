package com.empresa.Empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.Empresa.module.Producto;
import com.empresa.Empresa.service.IProductoService;
import com.empresa.Empresa.service.ProductoServiceImpl;

@RestController
@RequestMapping(path = "/empresa/sistema/producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>
{
	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/getProducto/{idProducto}")
	public ResponseEntity<?> getProducto( @PathVariable("idProducto") int idProducto  ) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body( iProductoService.findById(idProducto) );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}

}
