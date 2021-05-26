package com.empresa.Empresa.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.empresa.Empresa.module.Base;
import com.empresa.Empresa.repository.IBaseRepository;

public abstract class BaseServiceImpl<T extends Base, ID extends Serializable>
implements IBaseService<T, ID>
{
	protected IBaseRepository<T, ID> iBaseRepository;
	
	public BaseServiceImpl( IBaseRepository<T, ID> iBaseRepository)
	{
		this.iBaseRepository = iBaseRepository;
	}

	@Override
	public List<T> findAll() throws Exception {
		try {
			List<T> entities = this.iBaseRepository.findAll();
			return entities;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public T findById(ID id) throws Exception {
		try {
			Optional<T> entityOptional = this.iBaseRepository.findById(id);
			return entityOptional.get();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public T save(T entity) throws Exception {
		try {
			entity = this.iBaseRepository.save(entity);
			return entity;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public T update(ID id, T entity) throws Exception {
		try {
			
			Optional<T> entityOptional = this.iBaseRepository.findById(id);
			T entityUpdate = entityOptional.get();
			entityUpdate = this.iBaseRepository.save(entity);
			return entityUpdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean delete(ID id) throws Exception {
		try {
			
			if(this.iBaseRepository.existsById(id))
			{
				this.iBaseRepository.deleteById(id);
				return true;
			}else {
				throw new Exception( );
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
}
