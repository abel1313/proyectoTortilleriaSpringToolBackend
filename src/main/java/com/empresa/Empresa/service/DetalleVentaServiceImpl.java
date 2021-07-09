package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.DetalleVenta;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IDetalleRepository;

@Service
public class DetalleVentaServiceImpl extends BaseServiceImpl<DetalleVenta, Integer>implements IDetalleService
{

	@Autowired
	private IDetalleRepository iDetalleRepository;
	
	public DetalleVentaServiceImpl(IBaseRepository<DetalleVenta, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
