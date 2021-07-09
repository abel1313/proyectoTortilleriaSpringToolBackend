package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Venta;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IVentaRepository;

@Service
public class VentaServiceImpl extends BaseServiceImpl<Venta, Integer> implements IVentaService
{
	@Autowired
	private IVentaRepository iVentaRepository;

	public VentaServiceImpl(IBaseRepository<Venta, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
