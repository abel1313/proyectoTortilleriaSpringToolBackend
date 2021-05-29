package com.empresa.Empresa.service;

import java.util.Optional;

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

	@Override
	public Producto saveProd(int id, Producto p) throws Exception {
		// TODO Auto-generated method stub
		try {
			if( id != 0 && p != null)
			{
				Optional<Producto> optional = iProductoRepository.findById(p.getId());
				Producto productoNuevo = optional.get();
				productoNuevo = iProductoRepository.save(p);
				return productoNuevo;
			}
			throw new Exception();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
