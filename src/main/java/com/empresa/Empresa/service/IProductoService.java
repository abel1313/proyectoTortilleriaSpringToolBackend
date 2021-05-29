package com.empresa.Empresa.service;

import com.empresa.Empresa.module.Producto;


public interface IProductoService extends IBaseService<Producto, Integer>
{
	
			public Producto saveProd(int id, Producto p) throws Exception;
}
