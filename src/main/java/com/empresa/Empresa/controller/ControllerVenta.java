package com.empresa.Empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.Empresa.module.Venta;
import com.empresa.Empresa.service.IServiceVenta;
import com.empresa.Empresa.service.ServiceVentaImpl;

@RestController
@RequestMapping(path = "/empresa/sistema/venta")
public class ControllerVenta extends BaseControllerImpl<Venta, ServiceVentaImpl>
{
	@Autowired
	private IServiceVenta iServiceVenta;
	
	@GetMapping("/add")
	public ResponseEntity<?> getMensaje() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body( iServiceVenta.findAll() );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
}
