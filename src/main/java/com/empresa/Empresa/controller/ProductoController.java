package com.empresa.Empresa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.Empresa.module.Producto;
import com.empresa.Empresa.service.IProductoService;
import com.empresa.Empresa.service.IServiceVenta;
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
	
	@GetMapping("/actualizarProducto/{idProducto}/{nuevasExistencias}")
	public ResponseEntity<?> actualizarProducto( @PathVariable("idProducto") int idProducto ,@PathVariable("nuevasExistencias") double nuevasExistencias  ) {
		try {
			

		if( idProducto != 0 && nuevasExistencias != 0  )
			{	
			Producto producto = iProductoService.findById(idProducto);
			
			Producto p = new Producto();
			
				double actualizar = nuevasExistencias + producto.getDisponibilidadProducto(); 
				p.setDisponibilidadProducto( actualizar );
				p.setNombreProducto(producto.getNombreProducto());
				p.setPrecioProducto(producto.getPrecioProducto());
				p.setId(idProducto);				
	
				Producto r = iProductoService.saveProd(idProducto, p);
				
				return ResponseEntity.status(HttpStatus.OK).body( r );
			}
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde '}");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	@GetMapping("/disminuirProducto/{idProducto}/{disminuirExistencias}")
	public ResponseEntity<?> disminuirProducto( @PathVariable("idProducto") int idProducto ,@PathVariable("disminuirExistencias") double disminuirExistencias  ) {
		try {
			
		if( idProducto != 0 && disminuirExistencias != 0  )
			{	

			Producto producto = iProductoService.findById(idProducto);
			
			if( disminuirExistencias > producto.getDisponibilidadProducto() )
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde '}");
			}
			
			
			Producto p = new Producto();
			
				double actualizar =  producto.getDisponibilidadProducto() - disminuirExistencias ; 
				p.setDisponibilidadProducto( actualizar );
				p.setNombreProducto(producto.getNombreProducto());
				p.setPrecioProducto(producto.getPrecioProducto());
				p.setId(idProducto);				
				Producto r = iProductoService.saveProd(idProducto, p);
				return ResponseEntity.status(HttpStatus.OK).body( r );
			}
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde '}");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	

}
