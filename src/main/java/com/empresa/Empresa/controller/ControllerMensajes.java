package com.empresa.Empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.empresa.Empresa.module.Mensaje;
import com.empresa.Empresa.service.IMensajeService;
import com.empresa.Empresa.service.MensajeServiceImpl;


@RestController
@RequestMapping(path = "/empresa/sistema/contacto")
public class ControllerMensajes extends BaseControllerImpl<Mensaje, MensajeServiceImpl>
{
	@Autowired
	private IMensajeService iMensajeService;
	
	@GetMapping("/mensaje")
	public ResponseEntity<?> getMensaje() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body( iMensajeService.findAll() );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
}
