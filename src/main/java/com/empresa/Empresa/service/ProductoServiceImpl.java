package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Producto;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IProductoRepository;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer> implements IProductoService
{
	@Autowired
	private IProductoRepository iProductoRepository;

	public ProductoServiceImpl(IBaseRepository<Producto, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
