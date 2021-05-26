package com.empresa.Empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empresa.Empresa.module.Base;
import com.empresa.Empresa.service.BaseServiceImpl;

public abstract class BaseControllerImpl <E extends Base, S extends BaseServiceImpl<E, Integer>> 
implements IBaseController<E, Integer>
{
	@Autowired
	private S service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@Override
	public ResponseEntity<?> getaAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}

	@Override
	public ResponseEntity<?> getOne(Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde'}");
		}
	}

	@PostMapping("")
	//@ResponseBody
	@Override
	public ResponseEntity<?> save(@RequestBody E entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}

	@Override
	@PutMapping("")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody E entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde'}");
		}
	}

	@Override
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde'}");
		}
	}
}
