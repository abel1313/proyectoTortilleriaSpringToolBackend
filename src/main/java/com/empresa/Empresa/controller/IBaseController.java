package com.empresa.Empresa.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.empresa.Empresa.module.Base;



public interface IBaseController  <E extends Base, ID extends Serializable> 
{
	public ResponseEntity<?> getaAll();
	public ResponseEntity<?> getOne(@PathVariable ID id);
	public ResponseEntity<?> save(@RequestBody E entity);
	public ResponseEntity<?> update(@PathVariable ID id ,@RequestBody E entity);
	public ResponseEntity<?> delete(@PathVariable ID id);

}
