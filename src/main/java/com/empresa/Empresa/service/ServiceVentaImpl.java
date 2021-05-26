package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Venta;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IRepositoryVenta;

@Service
public class ServiceVentaImpl extends BaseServiceImpl<Venta, Integer>
implements IServiceVenta
{
	@Autowired
	private IRepositoryVenta iRepositoryVenta;
	
	public ServiceVentaImpl(IBaseRepository<Venta, Integer> iBaseRepository) {
		super(iBaseRepository);
	}

}
