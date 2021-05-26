package com.empresa.Empresa.service;

import java.io.Serializable;
import java.util.List;

import com.empresa.Empresa.module.Base;

public interface IBaseService <T extends Base, ID extends Serializable>
{
	public List<T> findAll() throws Exception;
	public T findById(ID id) throws Exception;
	public T save(T entity) throws Exception;
	public T update(ID id, T entity) throws Exception;
	public boolean delete(ID id) throws Exception;
}
